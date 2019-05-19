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
}
