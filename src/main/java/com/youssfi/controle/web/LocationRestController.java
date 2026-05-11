package com.youssfi.controle.web;

import com.youssfi.controle.dto.LocationDTO;
import com.youssfi.controle.services.interfaces.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LocationRestController {

    private final LocationService locationService;

    @GetMapping
    public List<LocationDTO> locations(){
        return locationService.getLocations();
    }

    @PostMapping
    public LocationDTO save(
            @RequestBody LocationDTO dto){

        return locationService.saveLocation(dto);
    }
}