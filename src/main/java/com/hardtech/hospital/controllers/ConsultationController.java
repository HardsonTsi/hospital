package com.hardtech.hospital.controllers;

import com.hardtech.hospital.entities.Consultation;
import com.hardtech.hospital.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/consultations")
    List<Consultation> getConsultations() {
        return consultationService.getConsultations();
    }

    @GetMapping("/consultations/{id}")
    Consultation getConsultation(@PathVariable Long id) {
        return consultationService.getConsultation(id);
    }

    @PostMapping("/consultations")
    Consultation saveConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultatation(consultation);
    }

    @PutMapping("/consultations")
    Consultation updateConsultation(@RequestBody Consultation consultation) {
        return consultationService.updateConsultation(consultation);
    }

    @DeleteMapping("/consultations/delete/{id}")
    void deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
    }
}
