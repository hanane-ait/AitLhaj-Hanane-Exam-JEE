package com.youssfi.controle.repositories;

import com.youssfi.controle.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository
        extends JpaRepository<Location, Long> {
}