package com.youssfi.controle.services.interfaces;

import com.youssfi.controle.dto.AgencyDTO;

import java.util.List;

public interface AgencyService {

    AgencyDTO saveAgency(AgencyDTO dto);

    List<AgencyDTO> getAgencies();

    AgencyDTO getAgency(Long id);

    void deleteAgency(Long id);
}