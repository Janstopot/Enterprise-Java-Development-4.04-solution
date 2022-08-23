package com.example.lab402.controller;

import com.example.lab402.enums.Status;
import com.example.lab402.model.Employee;
import com.example.lab402.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll(){
        return employeeService.findAllDoctors();
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findById(@PathVariable Long id){
        return employeeService.findDoctorById(id);
    }

    @GetMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findByStatus(@RequestParam Optional<Status> status, @RequestParam Optional<String> department){
        return employeeService.findDoctorByStatus(status, department);
    }





}
