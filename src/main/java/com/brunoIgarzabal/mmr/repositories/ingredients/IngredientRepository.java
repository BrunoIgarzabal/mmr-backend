package com.brunoIgarzabal.mmr.repositories.ingredients;

import com.brunoIgarzabal.mmr.domain.Ingredient;
import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends GenericRepository<Ingredient> {
}
