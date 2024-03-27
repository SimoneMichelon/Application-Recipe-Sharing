package com.simone.recipesharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simone.recipesharing.model.Recipe;
import com.simone.recipesharing.model.User;
import com.simone.recipesharing.service.RecipeService;
import com.simone.recipesharing.service.UserService;

@RestController
@RequestMapping("api/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public Recipe createRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		Recipe createdRecipe =  recipeService.createRecipe(recipe, user);
		
		return createdRecipe;
	}
	
	@GetMapping("")
	public List<Recipe> getAllRecipes() throws Exception {
		List<Recipe> recipes = recipeService.findAllRecipe();
		
		return recipes;
	}
	
	@DeleteMapping("/{recipeId}")
	public String deleteRecipes(@PathVariable Long recipeId) throws Exception {
		recipeService.deleteRecipe(recipeId);
		
		return "Recipe deleted successfully";
			
	}
	
	@PutMapping("/{id}")
	public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {
		Recipe updatedRecipe = recipeService.updateRecipe(recipe, id);
		return updatedRecipe;
	}
	
	@PutMapping("/{id}/like")
	public Recipe likeRecipe(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception {
		User user = userService.findUserByJwt(jwt);
		
		Recipe updatedRecipe = recipeService.likeRecipe(id, user);
		return updatedRecipe;
	}
	
	
	
	

}
