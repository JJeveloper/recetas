package com.gastronomia.recetas;

import com.gastronomia.recetas.entity.IngredientesEntity;
import com.gastronomia.recetas.entity.RecetaEntity;
import com.gastronomia.recetas.repository.IngredientesRepository;
import com.gastronomia.recetas.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RecetasApplication {



	public static void main(String[] args) {
		SpringApplication.run(RecetasApplication.class, args);
	}

	/*@Autowired
	IngredientesRepository ingredientesRepository;

	@Autowired
	RecetaRepository recetaRepository;


	@Override
	public void run(String... args) throws Exception {
		RecetaEntity re1 = new RecetaEntity("fff","fff");

		IngredientesEntity ie1 = new IngredientesEntity("paprica");
		IngredientesEntity ie2 = new IngredientesEntity("cebollin");

		ingredientesRepository.save(ie1);
		ingredientesRepository.save(ie2);


		List<IngredientesEntity> ingredientesEntities = new ArrayList<>();

		ingredientesEntities.add(ie1);
		ingredientesEntities.add(ie2);

		re1.setIngredientesEntities(ingredientesEntities);

		recetaRepository.save(re1);
	}*/
}
