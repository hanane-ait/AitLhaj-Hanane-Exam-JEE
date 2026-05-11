package com.youssfi.controle.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LocationDTO {

    private Long id;

    private Date dateDebut;

    private Date dateFin;

    private double prixTotal;
}