package com.youssfi.controle.entities;

import com.youssfi.controle.enums.FuelType;
import com.youssfi.controle.enums.GearBox;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car extends Vehicle {

    private int nombrePortes;

    @Enumerated(EnumType.STRING)
    private FuelType typeCarburant;

    @Enumerated(EnumType.STRING)
    private GearBox boiteVitesse;
}