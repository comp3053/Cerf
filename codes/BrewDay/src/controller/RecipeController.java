package controller;

import model.*;

import java.util.ArrayList;

public class RecipeController {
	private static RecipeController instance = new RecipeController();
	private ArrayList<Recipe> recipeList;
	
	public RecipeController() {
		
	}

    public static RecipeController GetInstance() {
        return instance;
    }
	
	public void addIngredient(ArrayList<RecipeIngredient> ri,String name, double amount, String unit) {
	    ri.add(new RecipeIngredient(name,amount,unit));
	}
	
	public void addRecipe(ArrayList<RecipeIngredient> ri, String name, double size) {
		Recipe newRecipe = new Recipe(name,size);
		for(RecipeIngredient r : ri) {
			newRecipe.AddIngredient(r);
		}
		recipeList = BrewData.getRecipeList();
		recipeList.add(newRecipe);
		BrewData.setRecipeList(recipeList);
	}
	
	public ArrayList<Recipe> recommend(double brewAmount){
		ArrayList<Recipe> recommend = new ArrayList<Recipe>();
		
		for(Recipe r : BrewData.getRecipeList()) {
			recommend.add(r.convertValue(brewAmount));
		}
		
		for(Recipe r : recommend) {
			for(RecipeIngredient i : r.GetIngredientList()) {
				if(!BrewData.getStorageIngredientList().contains(i)) {
					recommend.remove(r);
					break;
				}
				int index = BrewData.getStorageIngredientList().indexOf(i);
				if(i.getAmount() > BrewData.getStorageIngredientList().get(index).getAmount()) {
					recommend.remove(r);
					break;
				}
			}
		}
				
		if(recommend.size() == 0) {
			Recipe recipe = BrewData.getRecipeList().get(0);
			recommend.add(recipe);
			ShoppingList shoppingList = new ShoppingList();
			
			ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
			
			for(Ingredient i : recipe.GetIngredientList()) {
				double x = i.getAmount() - BrewData.getStorageIngredientList().get(0).getAmount();
				if(x > 0) {
					Ingredient shopIngre = new Ingredient(i.getName(),x,i.getUnit());
				}
			}
		}
		
		return recommend;
	}
}
