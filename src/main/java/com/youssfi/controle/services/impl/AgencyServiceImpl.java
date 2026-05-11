package com.youssfi.controle.services.impl;

import com.youssfi.controle.dto.AgencyDTO;
import com.youssfi.controle.entities.Agency;
import com.youssfi.controle.mappers.AgencyMapper;
import com.youssfi.controle.repositories.AgencyRepository;
import com.youssfi.controle.services.interfaces.AgencyService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    private final AgencyMapper agencyMapper;

    @Override
    public AgencyDTO saveAgency(AgencyDTO dto) {

        Agency agency = new Agency();

        agency.setNom(dto.getNom());
        agency.setVille(dto.getVille());

        Agency savedAgency =
                agencyRepository.save(agency);

        return agencyMapper.fromAgency(savedAgency);
    }

    @Override
    public List<AgencyDTO> getAgencies() {

        return agencyRepository.findAll()
                .stream()
                .map(agencyMapper::fromAgency)
                .collect(Collectors.toList());
    }

    @Override
    public AgencyDTO getAgency(Long id) {

        Agency agency =
                agencyRepository.findById(id)
                        .orElseThrow();

        return agencyMapper.fromAgency(agency);
    }

    @Override
    public void deleteAgency(Long id) {

        agencyRepository.deleteById(id);
    }
}