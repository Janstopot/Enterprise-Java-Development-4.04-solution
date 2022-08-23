package com.example.lab402.repository;

import com.example.lab402.enums.Status;
import com.example.lab402.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByDateOfBirthBetween(LocalDate start, LocalDate end);
    public List<Patient> findByAdmittedByDepartment(String department);

    public List<Patient> findByAdmittedByStatus(Status status);
}
