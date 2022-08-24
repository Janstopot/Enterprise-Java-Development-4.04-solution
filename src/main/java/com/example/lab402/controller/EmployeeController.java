package com.example.lab402.controller;

import com.example.lab402.dto.EmployeeDepartmentDTO;
import com.example.lab402.dto.EmployeeStatusDTO;
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

    @PostMapping("/new-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createNewEmployee(employee);
    }

    @PatchMapping("/update-employee-status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee updateStatus(@RequestBody EmployeeStatusDTO status, @RequestParam Long id){
        return employeeService.updateStatus(status, id);
    }

    @PatchMapping("/update-employee-department/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee updateDepartment(@RequestBody EmployeeDepartmentDTO department, @PathVariable Long id){
        return employeeService.updateDepartment(department, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }








}
