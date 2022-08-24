package com.example.lab402.dto;

import com.example.lab402.enums.Status;

import javax.validation.constraints.NotEmpty;

public class EmployeeStatusDTO {

    @NotEmpty
    private Status status;

    public EmployeeStatusDTO(Status status) {
        this.status = status;
    }

    public EmployeeStatusDTO() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
