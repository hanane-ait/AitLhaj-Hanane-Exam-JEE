package com.youssfi.controle.services.impl;

import com.youssfi.controle.dto.LocationDTO;
import com.youssfi.controle.entities.Location;
import com.youssfi.controle.mappers.LocationMapper;
import com.youssfi.controle.repositories.LocationRepository;
import com.youssfi.controle.services.interfaces.LocationService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    @Override
    public LocationDTO saveLocation(LocationDTO dto) {

        Location location = new Location();

        location.setDateDebut(dto.getDateDebut());
        location.setDateFin(dto.getDateFin());
        location.setPrixTotal(dto.getPrixTotal());

        Location savedLocation =
                locationRepository.save(location);

        return locationMapper.fromLocation(savedLocation);
    }

    @Override
    public List<LocationDTO> getLocations() {

        return locationRepository.findAll()
                .stream()
                .map(locationMapper::fromLocation)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO getLocation(Long id) {

        Location location =
                locationRepository.findById(id)
                        .orElseThrow();

        return locationMapper.fromLocation(location);
    }

    @Override
    public void deleteLocation(Long id) {

        locationRepository.deleteById(id);
    }
}