package com.youssfi.controle.dto;

import lombok.Data;

@Data
public class VehicleDTO {

    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;
}