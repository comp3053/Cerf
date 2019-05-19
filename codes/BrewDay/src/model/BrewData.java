package model;

import java.util.ArrayList;

public class BrewData {
    private ArrayList<Recipe> recipeList;
    private ArrayList<StorageIngredient> storageIngredientList;
    private ArrayList<Note> noteList;
    private ArrayList<Equipment> equipmentList;
	
	public BrewData() {
		init();
	}
	
	public void init() {
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
        return this.recipeList;
    }

    public void setRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public ArrayList<StorageIngredient> getStorageIngredientList() {
        return this.storageIngredientList;
    }

    public void setStorageIngredientList(ArrayList<StorageIngredient> storageIngredientList) {
        this.storageIngredientList = storageIngredientList;
    }

    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(ArrayList<Note> noteList) {
        this.noteList = noteList;
    }

    public ArrayList<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(ArrayList<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
}