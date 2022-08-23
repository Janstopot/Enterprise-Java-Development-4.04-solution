package com.example.lab402.service;

import com.example.lab402.enums.Status;
import com.example.lab402.model.Patient;
import com.example.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long id){
        return patientRepository.findById(id).get();
    }

    public List<Patient> findPatientByDOB(LocalDate start, LocalDate end){
        return  patientRepository.findByDateOfBirthBetween(start, end);
    }

    public List<Patient> findPatientByDepartment(String department){
        return patientRepository.findByAdmittedByDepartment(department);
    }

    public List<Patient> findPatientByStatus(Status status){
        System.out.println("ENUMMMMMM " + status.name());
        return patientRepository.findByAdmittedByDepartment(status.name());
    }


}
