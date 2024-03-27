import { Component } from '@angular/core';
import { RecipeService } from 'src/app/services/Recipe/recipe.service';


@Component({
  selector: 'app-create-recipe-form',
  templateUrl: './create-recipe-form.component.html',
  styleUrls: ['./create-recipe-form.component.css']
  
})
export class CreateRecipeFormComponent {

  recipeItem: any ={
    title:"",
    image:"",
    foodType:"",
    description:""
  }

  constructor(private recipeService:RecipeService){

  }

  onSubmit(){
    console.log("values", this.recipeItem)
    this.recipeService.createRecipes(this.recipeItem).subscribe(
      {
        next:data=> console.log("created recipe", data),
        error : error => console.log("error", error)
      }
    )
  }

}
