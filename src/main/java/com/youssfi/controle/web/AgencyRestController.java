package com.youssfi.controle.web;

import com.youssfi.controle.dto.AgencyDTO;
import com.youssfi.controle.services.interfaces.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AgencyRestController {

    private final AgencyService agencyService;

    @GetMapping
    public List<AgencyDTO> agencies(){
        return agencyService.getAgencies();
    }

    @PostMapping
    public AgencyDTO save(
            @RequestBody AgencyDTO dto){

        return agencyService.saveAgency(dto);
    }
}