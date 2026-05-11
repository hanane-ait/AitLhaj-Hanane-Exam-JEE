package com.youssfi.controle.services.impl;

import com.youssfi.controle.dto.VehicleDTO;
import com.youssfi.controle.entities.Car;
import com.youssfi.controle.entities.Vehicle;
import com.youssfi.controle.mappers.VehicleMapper;
import com.youssfi.controle.repositories.VehicleRepository;
import com.youssfi.controle.services.interfaces.VehicleService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO dto) {

        Car car = new Car();

        car.setMarque(dto.getMarque());
        car.setModele(dto.getModele());
        car.setMatricule(dto.getMatricule());
        car.setPrixParJour(dto.getPrixParJour());

        Vehicle savedVehicle =
                vehicleRepository.save(car);

        return vehicleMapper.fromVehicle(savedVehicle);
    }

    @Override
    public List<VehicleDTO> getVehicles() {

        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::fromVehicle)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicle(Long id) {

        Vehicle vehicle =
                vehicleRepository.findById(id)
                        .orElseThrow();

        return vehicleMapper.fromVehicle(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);
    }
}