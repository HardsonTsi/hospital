package com.hardtech.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    @OneToMany(mappedBy = "medecin", fetch = FetchType.EAGER)
    private List<RendezVous> rendezVous = new ArrayList<>();
}
