package com.example.lab402.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PatientDTO {

    @NotNull
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private Long doctorId;

    public PatientDTO(String name, LocalDate dateOfBirth, Long doctorId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.doctorId = doctorId;
    }

    public PatientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
