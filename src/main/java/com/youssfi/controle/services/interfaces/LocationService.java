package com.youssfi.controle.services.interfaces;

import com.youssfi.controle.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    LocationDTO saveLocation(LocationDTO dto);

    List<LocationDTO> getLocations();

    LocationDTO getLocation(Long id);

    void deleteLocation(Long id);
}