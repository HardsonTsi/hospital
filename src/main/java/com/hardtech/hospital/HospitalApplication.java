package com.hardtech.hospital;

import com.hardtech.hospital.entities.*;
import com.hardtech.hospital.repositories.ConsultationRepository;
import com.hardtech.hospital.repositories.MedecinRepository;
import com.hardtech.hospital.repositories.PatientRepository;
import com.hardtech.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {

            //Ajout de patients
            List.of("Hardson", "Modeste", "Enagnon", "Segla", "Tessi")
                    .forEach(name -> {
                                Patient patient = new Patient();
                                patient.setNom(name);
                                patient.setDateNaissance(LocalDate.now());
                                patient.setMalade(Math.random() > 0.5);
                                patientRepository.save(patient);
                            }
                    );

            //Ajout de médecins
            List.of("Tessi", "Agossou", "Avahouin", "Saizonu", "Zannou")
                    .forEach(name -> {
                                Medecin medecin = new Medecin();
                                medecin.setNom(name);
                                medecin.setEmail(name + "@gmail.com");
                                medecin.setSpecialite(generateSpecialite());
                                medecinRepository.save(medecin);
                            }
                    );


            //Ajout de Rendez-vous
            List<Patient> patients = patientRepository.findAll();
            patients.forEach(patient -> {
                int random = generateNumber();
                Medecin medecin = medecinRepository.findById((long) random).orElse(null);
                RendezVous rendezVous = new RendezVous();
                rendezVous.setPatient(patient);
                rendezVous.setMedecin(medecin);
                rendezVous.setStatus((random >= 0 && random <= 4) ? StatusRDV.DONE : (random >= 5 && random < 7) ? StatusRDV.CANCELED : StatusRDV.PENDING);
                rendezVous.setDate(LocalDate.of(random * 224, random > 3 ? Month.APRIL : Month.NOVEMBER, random));
                rendezVousRepository.save(rendezVous);
            });


            //Ajout de consultations
            List<RendezVous> rendezVousList = rendezVousRepository.findAll();
            rendezVousList.forEach(rendezVous -> {
                int random = generateNumber();
                Consultation consultation = new Consultation();
                consultation.setDateConsultation(LocalDate.of(random * 224, random > 3 ? Month.DECEMBER : Month.MARCH, random));
                consultation.setRendezVous(rendezVous);
                consultationRepository.save(consultation);
            });

        };

    }

    //Fonction pour générer des spécialités aléatoirement
    private Specialite generateSpecialite() {

        Specialite specialite = null;
        int random = generateNumber();

        switch (random) {
            case 1:
                specialite = Specialite.Dermatology;
                break;
            case 2:
                specialite = Specialite.Nephrology;
                break;
            case 3:
                specialite = Specialite.Pediatrics;
                break;
            case 4:
                specialite = Specialite.Psychiatry;
                break;
            case 5:
                specialite = Specialite.Neurosurgery;
                break;
        }
        return specialite;
    }

    private int generateNumber() {
        int random;
        do {
            random = (int) (Math.random() * 10);

        } while (random == 0 || random > 5);
        return random;
    }

}
