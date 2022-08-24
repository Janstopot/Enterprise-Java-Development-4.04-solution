package com.example.lab402.dto;

import javax.validation.constraints.NotEmpty;

public class EmployeeDepartmentDTO {
    @NotEmpty
    private String department;

    public EmployeeDepartmentDTO(String department) {
        this.department = department;
    }

    public EmployeeDepartmentDTO() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
