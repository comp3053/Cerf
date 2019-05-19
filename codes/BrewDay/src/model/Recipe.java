package model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<RecipeIngredient> ingredientList;
    private double size;

    Recipe(String name, double size) {
        this.name = name;
        this.size = size;
        ingredientList = new ArrayList<>();
    }

    void AddIngredient(RecipeIngredient ri) {
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

    void setIngredientAmount(String name, double amount, String unit) {
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().equals(name)) {
                ingredientList.remove(ingredient);
            }
        }
        RecipeIngredient ri = new RecipeIngredient(name, amount, unit);
        ingredientList.add(ri);
    }
}
