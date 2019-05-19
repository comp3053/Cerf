package model;

import java.util.ArrayList;

public class BrewData {
    public static ArrayList<Recipe> recipeList;
    public static ArrayList<StorageIngredient> storageIngredientList;
    public static ArrayList<Note> noteList;
    public static ArrayList<Equipment> equipmentList;
	
	public static void init() {
		recipeList = new ArrayList<Recipe>();
		storageIngredientList = new ArrayList<StorageIngredient>();
		equipmentList = new ArrayList<Equipment>();
		
		Recipe beer = new Recipe("Beer",1000);
		beer.AddIngredient(new RecipeIngredient("Water",500,"ml"));
		recipeList.add(beer);
		
		storageIngredientList.add(new StorageIngredient("Water", 5000, "ml"));
		storageIngredientList.add(new StorageIngredient("Suger", 5000, "ml"));
		storageIngredientList.add(new StorageIngredient("Yeast", 5000, "ml"));
		
		equipmentList.add(new Equipment("Brewer One", 1000));
	}
	
    public ArrayList<Recipe> getRecipeList() {
        return BrewData.recipeList;
    }

    public void setRecipeList(ArrayList<Recipe> recipeList) {
    	BrewData.recipeList = recipeList;
    }

    public static ArrayList<StorageIngredient> getStorageIngredientList() {
        return BrewData.storageIngredientList;
    }

    public void setStorageIngredientList(ArrayList<StorageIngredient> storageIngredientList) {
    	BrewData.storageIngredientList = storageIngredientList;
    }

    public ArrayList<Note> getNoteList() {
        return BrewData.noteList;
    }

    public void setNoteList(ArrayList<Note> noteList) {
    	BrewData.noteList = noteList;
    }

    public ArrayList<Equipment> getEquipmentList() {
        return BrewData.equipmentList;
    }

    public void setEquipmentList(ArrayList<Equipment> equipmentList) {
    	BrewData.equipmentList = equipmentList;
    }
}