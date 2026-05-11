package com.youssfi.controle.repositories;

import com.youssfi.controle.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}