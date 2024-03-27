package com.simone.recipesharing.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simone.recipesharing.model.Recipe;
import com.simone.recipesharing.model.User;
import com.simone.recipesharing.repository.RecipeRepository;

@Service
public class RecipeServiceImplementation implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Recipe createRecipe(Recipe recipe, User user) {

		Recipe createdRecipe = new Recipe();
		createdRecipe.setTitle(recipe.getTitle());
		createdRecipe.setImage(recipe.getImage());
		createdRecipe.setDescription(recipe.getDescription());
		createdRecipe.setVegetarian(recipe.isVegetarian());
		createdRecipe.setUser(user);
		createdRecipe.setCreatedAt(LocalDateTime.now());

		return recipeRepository.save(createdRecipe);
	}

	@Override
	public Recipe findRecipeById(Long id) throws Exception {
		Optional<Recipe> opt = recipeRepository.findById(id);

		if(opt.isPresent()) 
		{
			return opt.get();
		}

		throw new Exception("recipe not found with id "+ id);
	}

	@Override
	public void deleteRecipe(Long id) throws Exception {
		//Il metodo di deleteById(id)  se lo trova lo elimina altrimenti ignora, perciò non dovrebbe servire il find.
		//findRecipeById(id);
		
		recipeRepository.deleteById(id);
	}

	@Override
	public Recipe updateRecipe(Recipe recipe, Long id) throws Exception {
		
		//old recipe to update
		Recipe oldRecipe = findRecipeById(id);
		
		//updating all recipe attributes
		if(recipe.getTitle() != null) {
			oldRecipe.setTitle(recipe.getTitle());
		}
		
		if(recipe.getImage() != null) {
			oldRecipe.setImage(recipe.getImage());
		}
		
		if(recipe.getDescription() != null) {	
			oldRecipe.setDescription(recipe.getDescription());
		}
		
		if(recipe.isVegetarian() != oldRecipe.isVegetarian()) {
			oldRecipe.setVegetarian(recipe.isVegetarian());
		}
		return recipeRepository.save(oldRecipe);
	}

	@Override
	public List<Recipe> findAllRecipe() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe likeRecipe(Long recipeId, User user) throws Exception {
		Recipe recipe = findRecipeById(recipeId);
		
		//se la lista di likes contiene l'id dello user, lo rimuove, altrimenti lo aggiunge
		if(recipe.getLikes().contains(user.getId())){
			recipe.getLikes().remove(user.getId());
		}
		else {
			recipe.getLikes().add(user.getId());
		}
		return recipeRepository.save(recipe);
	}

}
