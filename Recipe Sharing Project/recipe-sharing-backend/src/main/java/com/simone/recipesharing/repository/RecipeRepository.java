package com.simone.recipesharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simone.recipesharing.model.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Long>{

    public Recipe findByTitle(String title) throws Exception;

}
