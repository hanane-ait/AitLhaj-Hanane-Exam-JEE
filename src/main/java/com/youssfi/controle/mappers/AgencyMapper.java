package com.youssfi.controle.mappers;

import com.youssfi.controle.dto.AgencyDTO;
import com.youssfi.controle.entities.Agency;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AgencyMapper {

    public AgencyDTO fromAgency(Agency agency){

        AgencyDTO dto = new AgencyDTO();

        BeanUtils.copyProperties(agency, dto);

        return dto;
    }

    public Agency fromAgencyDTO(AgencyDTO dto){

        Agency agency = new Agency();

        BeanUtils.copyProperties(dto, agency);

        return agency;
    }
}