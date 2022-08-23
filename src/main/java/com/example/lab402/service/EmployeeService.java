package com.example.lab402.service;

import com.example.lab402.enums.Status;
import com.example.lab402.model.Employee;
import com.example.lab402.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllDoctors(){
        return employeeRepository.findAll();
    }

    public Employee findDoctorById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findDoctorByStatus(Optional<Status> status, Optional<String> department){
        if(status.isPresent()){
            return employeeRepository.findByStatus(status.get());
        }
        if(department.isPresent()){
            return employeeRepository.findByDepartment(department.get());
        }
        return null;

    }


}
