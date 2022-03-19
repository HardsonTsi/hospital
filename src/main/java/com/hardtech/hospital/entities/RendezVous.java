package com.hardtech.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Enumerated
    private StatusRDV status;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patient;

    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
