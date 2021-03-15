package com.brunoIgarzabal.mmr;

import com.brunoIgarzabal.mmr.domain.Difficulty;
import com.brunoIgarzabal.mmr.domain.UnitOfMeasurement;
import com.brunoIgarzabal.mmr.repositories.difficulties.DifficultyRepository;
import com.brunoIgarzabal.mmr.repositories.unitsOfMeasurements.UnitOfMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MmrApplication implements CommandLineRunner {

	@Autowired
	private DifficultyRepository difficultyRepository;
	@Autowired
	private UnitOfMeasurementRepository unitOfMeasurementRepository;

	public static void main(String[] args) {
		SpringApplication.run(MmrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Difficulty difEasy = new Difficulty(null, "Fácil", "0");
		Difficulty difNormal = new Difficulty(null, "Média", "1");
		Difficulty difHard = new Difficulty(null, "Difícil", "2");

		difficultyRepository.saveAll(Arrays.asList(difEasy, difNormal, difHard));

		UnitOfMeasurement unit1 = new UnitOfMeasurement(null, "Colher de sopa", "colher de sopa", "colheres de sopa");
		UnitOfMeasurement unit2 = new UnitOfMeasurement(null, "Grama", "g", "g");
		UnitOfMeasurement unit3 = new UnitOfMeasurement(null, "Litro", "l", "l");

		unitOfMeasurementRepository.saveAll(Arrays.asList(unit1, unit2, unit3));
	}
}
