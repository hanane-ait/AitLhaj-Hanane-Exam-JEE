package com.youssfi.controle.mappers;

import com.youssfi.controle.dto.LocationDTO;
import com.youssfi.controle.entities.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDTO fromLocation(Location location){

        LocationDTO dto = new LocationDTO();

        BeanUtils.copyProperties(location, dto);

        return dto;
    }

    public Location fromLocationDTO(LocationDTO dto){

        Location location = new Location();

        BeanUtils.copyProperties(dto, location);

        return location;
    }
}