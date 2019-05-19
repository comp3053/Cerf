package model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<RecipeIngredient> ingredientList;
    private final double size;

    public Recipe(String name, double size) {
        this.name = name;
        this.size = size;
        ingredientList = new ArrayList<>();
    }

    public void AddIngredient(RecipeIngredient ri) {
        ingredientList.add(ri);
    }

    public String getRecipeName() {
        return this.name;
    }

    void setRecipeName(String name) {
        this.name = name;
    }

    public ArrayList<RecipeIngredient> GetIngredientList() {
        return this.ingredientList;
    }

    public double getSize() {
        return this.size;
    }

    public void setIngredientAmount(String name, double amount, String unit) {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(name)) {
                ingredientList.remove(ingredient);
            }
        }
        RecipeIngredient ri = new RecipeIngredient(name, amount, unit);
        ingredientList.add(ri);
    }
    
    public void convertValue(double targetValue) {
    	
    }
}
