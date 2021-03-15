package com.brunoIgarzabal.mmr;

import com.brunoIgarzabal.mmr.domain.*;
import com.brunoIgarzabal.mmr.repositories.categories.CategoryRepository;
import com.brunoIgarzabal.mmr.repositories.difficulties.DifficultyRepository;
import com.brunoIgarzabal.mmr.repositories.ingredients.IngredientRepository;
import com.brunoIgarzabal.mmr.repositories.preparationModeRecipe.PreparationModeRecipeRepository;
import com.brunoIgarzabal.mmr.repositories.recipes.RecipeRepository;
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
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PreparationModeRecipeRepository methodRecipeRepository;

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

		Recipe recipe1 = new Recipe(null, "Bolo de Chocolate", "http://google.com", 0, 0, 20, 3, 750.0, difNormal);

		Category category = new Category(null, "Bolos", "http://google.com");
		category.getRecipes().addAll(Arrays.asList(recipe1));

		recipe1.getCategories().addAll(Arrays.asList(category));

		recipeRepository.saveAll(Arrays.asList(recipe1));
		categoryRepository.saveAll(Arrays.asList(category));


		Ingredient ingredient1 = new Ingredient(null, "Achocolatado", "3", recipe1, unit1);
		Ingredient ingredient2 = new Ingredient(null, "Leite Condensado", "300", recipe1, unit2);
		ingredientRepository.saveAll(Arrays.asList(ingredient1, ingredient2));

		PreparationModeRecipe methodRecipe1 = new PreparationModeRecipe(null, 1, "Colocar o achocolato junto com o...", recipe1);
		PreparationModeRecipe methodRecipe2 = new PreparationModeRecipe(null, 2, "Misturar bem o... com o....", recipe1);
		methodRecipeRepository.saveAll(Arrays.asList(methodRecipe1, methodRecipe2));


	}
}
