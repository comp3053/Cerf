package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import model.BrewData;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;

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
		
		for(Recipe r : BrewData.getRecipeList()) {
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
				
		
		return recommend;
	}
}
