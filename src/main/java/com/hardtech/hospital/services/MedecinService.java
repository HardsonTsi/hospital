package com.hardtech.hospital.services;


import com.hardtech.hospital.entities.Medecin;
import com.hardtech.hospital.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;


    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public List<Medecin> getMedecins() {
        return medecinRepository.findAll();
    }

    public Medecin getMedecin(Long id) {
        return medecinRepository.findById(id).get();
    }


    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }

    public Medecin updateMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
}
