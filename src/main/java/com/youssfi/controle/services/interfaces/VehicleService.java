package com.youssfi.controle.services.interfaces;

import com.youssfi.controle.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(VehicleDTO dto);

    List<VehicleDTO> getVehicles();

    VehicleDTO getVehicle(Long id);

    void deleteVehicle(Long id);
}