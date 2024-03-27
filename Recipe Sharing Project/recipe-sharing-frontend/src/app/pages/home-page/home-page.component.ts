import { Component, OnInit } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { AuthService } from 'src/app/services/Auth/auth.service';
import { RecipeService } from 'src/app/services/Recipe/recipe.service';
import { CreateRecipeFormComponent } from '../create-recipe-form/create-recipe-form.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit{

  recipes = [];

  constructor(public dialog : MatDialog,
    public authService : AuthService,
      private recipeService : RecipeService ){

  }
  

  handleOpenCreateRecipeDialog(){
    this.dialog.open(CreateRecipeFormComponent);
  }

  ngOnInit(){
    this.authService.getUserProfile();
    this.recipeService.getRecipes().subscribe();
    this.recipeService.recipeSubject.subscribe(
      (state) =>{
        this.recipes=state.recipes
      })
  }
}
