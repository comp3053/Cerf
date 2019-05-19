package model;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<RecipeIngredient> ingredientList;
    private double size;

    public Recipe(String name, double size) {
        this.name = name;
        this.size = size;
        ingredientList = new ArrayList<RecipeIngredient>();
    }

    public void AddIngredient(RecipeIngredient ri) {
        ingredientList.add(ri);
    }

    public String GetRecipeName() {
        return this.name;
    }

    public ArrayList<RecipeIngredient> GetIngredientList() {
        return this.ingredientList;
    }

    public double GetSize() {
        return this.size;
    }

    public void SetRecipeName(String name) {
        this.name = name;
    }

    public void SetIngredientAmount(String name, double amount, String unit) {
        ingredientList.remove(name);
        RecipeIngredient ri = new RecipeIngredient(name, amount, unit);
        ingredientList.add(ri);
    }

//    Map<String, Double> convertValue(double batchSize) {
//        Map<String, Double> convertedIngredientList = new TreeMap<>();
//        for (String key : ingredientList.keySet()) {
//            convertedIngredientList.put(key, ingredientList.get(key) / (this.size) * batchSize);
//        }
//        return convertedIngredientList;
//    }
}
