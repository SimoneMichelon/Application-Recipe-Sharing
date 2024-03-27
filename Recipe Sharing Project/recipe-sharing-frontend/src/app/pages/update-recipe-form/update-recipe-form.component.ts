import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RecipeService } from 'src/app/services/Recipe/recipe.service';

@Component({
  selector: 'app-update-recipe-form',
  templateUrl: './update-recipe-form.component.html',
  styleUrls: ['./update-recipe-form.component.css']
})
export class UpdateRecipeFormComponent implements OnInit{

  recipeItem: any ={
    title:"",
    description:"",
    image:"",
    foodType:"",
    
  }

  constructor( @Inject(MAT_DIALOG_DATA) public recipe: any,  private recipeService : RecipeService){

  }

  onSubmit(){
    this.recipeService.updateRecipes(this.recipeItem  ).subscribe(
      {
        next:data=> console.log("updated recipe", data),
        error : error => console.log("error", error)
      }
    );
    console.log("values", this.recipeItem)
  }

  ngOnInit(){
    this.recipeItem = this.recipe
  }
}
