package com.example.lab402.controller;

import com.example.lab402.dto.PatientDTO;
import com.example.lab402.enums.Status;
import com.example.lab402.model.Patient;
import com.example.lab402.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAllPatients(){
        return patientService.findAllPatients();
    }

    @GetMapping("/patients-date")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByDOB(@RequestParam String start, @RequestParam String end){
        LocalDate startParsed = LocalDate.parse(start);
        LocalDate endParsed = LocalDate.parse(end);

        System.out.println("STARTTTTT " + startParsed);
        System.out.println("EEEENDDDDDD " + endParsed);
        return  patientService.findPatientByDOB(startParsed, endParsed);
    }

    @GetMapping("/patient-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByDepartment(@PathVariable String department){
        return patientService.findPatientByDepartment(department);
    }

    @GetMapping("/patient-status")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findByStatus(@RequestParam String status){
        return patientService.findPatientByStatus(Status.valueOf(status));
    }

    @PostMapping("/new-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createNewPatient(@RequestBody PatientDTO patientDTO){
        return patientService.createNewPatient(patientDTO);
    }

    @PutMapping("/update-patient")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Patient updatePatient(@RequestBody PatientDTO patientDTO){
        System.out.println("IDDD" + patientDTO.getId());
        return patientService.updatePatient(patientDTO);
    }



}
