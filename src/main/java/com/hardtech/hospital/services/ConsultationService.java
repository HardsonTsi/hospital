package com.hardtech.hospital.services;

import com.hardtech.hospital.entities.Consultation;
import com.hardtech.hospital.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation saveConsultatation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation getConsultation(Long id) {
        return consultationRepository.findById(id).get();
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    public Consultation updateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }


}
