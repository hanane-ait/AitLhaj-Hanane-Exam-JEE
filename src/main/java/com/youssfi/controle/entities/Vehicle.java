package com.youssfi.controle.entities;

import com.youssfi.controle.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;

    @Temporal(TemporalType.DATE)
    private Date dateMiseEnService;

    @Enumerated(EnumType.STRING)
    private VehicleStatus statut;

    @ManyToOne
    private Agency agency;

    @OneToMany(mappedBy = "vehicle")
    private List<Rental> rentals;
}