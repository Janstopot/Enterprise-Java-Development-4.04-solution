package com.example.lab402.repository;

import com.example.lab402.enums.Status;
import com.example.lab402.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByStatus(Status status);
    public List<Employee> findByDepartment(String department);
}
