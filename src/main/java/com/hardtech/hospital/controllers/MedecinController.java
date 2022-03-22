package com.hardtech.hospital.controllers;

import com.hardtech.hospital.entities.Medecin;
import com.hardtech.hospital.services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping("/medecins")
    List<Medecin> getMedecins() {
        return medecinService.getMedecins();
    }

    @GetMapping("/medecins/{id}")
    Medecin getMedecin(@PathVariable Long id) {
        return medecinService.getMedecin(id);
    }

    @PostMapping("/medecins")
    Medecin saveMedecin(@RequestBody Medecin medecin) {
        return medecinService.saveMedecin(medecin);
    }

    @PutMapping("/medecins")
    Medecin updateMedecin(@RequestBody Medecin medecin) {
        return medecinService.updateMedecin(medecin);
    }

    @DeleteMapping("/medecins/delete/{id}")
    void deleteMedecin(@PathVariable Long id) {
        medecinService.deleteMedecin(id);
    }
}
