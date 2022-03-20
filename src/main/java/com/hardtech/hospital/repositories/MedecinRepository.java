package com.hardtech.hospital.repositories;

import com.hardtech.hospital.entities.Medecin;
import com.hardtech.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByNom(String nom);

}
