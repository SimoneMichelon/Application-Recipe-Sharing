import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { RecipeService } from 'src/app/services/Recipe/recipe.service';
import { UpdateRecipeFormComponent } from '../update-recipe-form/update-recipe-form.component';

@Component({
  selector: 'app-recipe-card',
  templateUrl: './recipe-card.component.html',
  styleUrls: ['./recipe-card.component.css']
})
export class RecipeCardComponent {
  @Input() recipe:any

  constructor(public dialog:MatDialog, private recipeService:RecipeService){
    
  }

  handleOpenEditRecipeForm(){
    this.dialog.open(UpdateRecipeFormComponent, {
      data :this.recipe})
  }

  handleDeleteRecipe(){
    this.recipeService.deleteRecipes(this.recipe.id).subscribe();
  }
}
