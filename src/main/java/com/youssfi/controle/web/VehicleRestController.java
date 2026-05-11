package com.youssfi.controle.web;

import com.youssfi.controle.dto.VehicleDTO;
import com.youssfi.controle.services.interfaces.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VehicleRestController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<VehicleDTO> vehicles(){
        return vehicleService.getVehicles();
    }

    @PostMapping
    public VehicleDTO save(
            @RequestBody VehicleDTO dto){

        return vehicleService.saveVehicle(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
    }
}