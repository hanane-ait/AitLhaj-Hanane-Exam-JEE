package com.youssfi.controle.entities;

import com.youssfi.controle.enums.MotoType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Moto extends Vehicle {

    private double cylindree;

    @Enumerated(EnumType.STRING)
    private MotoType typeMoto;

    private boolean casqueInclus;
}