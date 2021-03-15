package com.brunoIgarzabal.mmr.repositories.recipes;

import com.brunoIgarzabal.mmr.domain.Recipe;
import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends GenericRepository<Recipe> {
}
