package com.example.lab402.service;

import com.example.lab402.dto.PatientDTO;
import com.example.lab402.enums.Status;
import com.example.lab402.model.Employee;
import com.example.lab402.model.Patient;
import com.example.lab402.repository.EmployeeRepository;
import com.example.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

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

    public Patient createNewPatient(PatientDTO patientDTO){
        if(employeeRepository.findById(patientDTO.getDoctorId()).isPresent()){

            Employee employee = employeeRepository.findById(patientDTO.getDoctorId()).get();

            Patient newPatient = new Patient();

            newPatient.setId(patientDTO.getId());
            newPatient.setName(patientDTO.getName());
            newPatient.setDateOfBirth(patientDTO.getDateOfBirth());
            newPatient.setAdmittedBy(employee);

            return patientRepository.save(newPatient);

        }
        return null;

    }

    public Patient updatePatient(PatientDTO patientDTO){
        if(patientRepository.findById(patientDTO.getId()).isPresent()){

            Patient updatedPatient = patientRepository.findById(patientDTO.getId()).get();

            if(patientDTO.getName() != null){
                updatedPatient.setName(patientDTO.getName());
            }
            if(patientDTO.getDateOfBirth() != null){
                updatedPatient.setDateOfBirth(patientDTO.getDateOfBirth());
            }
            if(patientDTO.getDoctorId() != null){
                System.out.println("BEFORE DOCTOR CHECKK !!!! ");
                if(employeeRepository.findById(patientDTO.getDoctorId()).isPresent()){
                    System.out.println("DOCTOR CHECK  !!!!!!");
                    Employee newDoctor = employeeRepository.findById(patientDTO.getDoctorId()).get();
                    updatedPatient.setAdmittedBy(newDoctor);
                }
            }

            return patientRepository.save(updatedPatient);
        }
        return null;
    }


}
