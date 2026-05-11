package com.youssfi.controle.mappers;

import com.youssfi.controle.dto.VehicleDTO;
import com.youssfi.controle.entities.Vehicle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDTO fromVehicle(Vehicle vehicle){

        VehicleDTO dto = new VehicleDTO();

        BeanUtils.copyProperties(vehicle, dto);

        return dto;
    }

    public Vehicle fromVehicleDTO(VehicleDTO dto){

        Vehicle vehicle = new com.youssfi.controle.entities.Car();

        BeanUtils.copyProperties(dto, vehicle);

        return vehicle;
    }
}