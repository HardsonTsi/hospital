package com.hardtech.hospital.controllers;

import com.hardtech.hospital.entities.Patient;
import com.hardtech.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/patients")
    Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/patients")
    Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patients/delete/{id}")
    void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }


}
