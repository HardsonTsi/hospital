package com.hardtech.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor @AllArgsConstructor
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private LocalDate dateNaissance;

    private boolean malade;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    private List<RendezVous> rendezVous = new ArrayList<>();
}
