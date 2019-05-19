package model;

import java.util.ArrayList;

public class BrewData {
    private ArrayList<Recipe> recipeList;
    private ArrayList<StorageIngredient> storageIngredientList;

    public BrewData() {
        init();
    }

    public void init() {
        recipeList = new ArrayList<>();
        storageIngredientList = new ArrayList<>();

        Recipe beer = new Recipe("Beer", 1000);
        beer.AddIngredient(new RecipeIngredient("Water", 500, "ml"));
        recipeList.add(beer);
    }

    public ArrayList<Recipe> GetRecipeList() {
        return this.recipeList;
    }

    public void SetRecipeList(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public ArrayList<StorageIngredient> GetStorageIngredientList() {
        return this.storageIngredientList;
    }

    public void SetStorageIngredientList(ArrayList<StorageIngredient> storageIngredientList) {
        this.storageIngredientList = storageIngredientList;
    }
}