package com.youssfi.controle;

import com.youssfi.controle.entities.*;
import com.youssfi.controle.enums.*;
import com.youssfi.controle.repositories.AgencyRepository;
import com.youssfi.controle.repositories.LocationRepository;
import com.youssfi.controle.repositories.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ControleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			AgencyRepository agencyRepository,
			VehicleRepository vehicleRepository,
			LocationRepository locationRepository){

		return args -> {

			Agency agency = Agency.builder()
					.nom("Agence Casa")
					.adresse("Maarif")
					.ville("Casablanca")
					.telephone("0600000000")
					.build();

			agencyRepository.save(agency);

			Car car = new Car();
			car.setMarque("BMW");
			car.setModele("X6");
			car.setMatricule("123-A-11");
			car.setPrixParJour(800);
			car.setStatut(
					VehicleStatus.DISPONIBLE);

			car.setAgency(agency);

			vehicleRepository.save(car);

			Location location = Location.builder()
					.dateDebut(new Date())
					.dateFin(new Date())
					.prixTotal(2400)
					.vehicle(car)
					.build();

			locationRepository.save(location);
		};
	}
}