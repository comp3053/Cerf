package model;

import java.util.Map;
import java.util.TreeMap;

public class Recipe {
    private String name;
    private Map<String, Double> ingredientList = new TreeMap<>();
    private double size;

    Recipe(String name, double size) {
        this.name = name;
        this.size = size;
    }

    void AddIngredient(RecipeIngredient ri) {
        ingredientList.put(ri.GetName(), ri.GetAmount());
    }

    public String GetRecipeName() {
        return this.name;
    }

    public Map<String, Double> GetIngredientList() {
        return this.ingredientList;
    }

    public double GetSize() {
        return this.size;
    }

    public void SetRecipeName(String name) {
        this.name = name;
    }

    public void SetIngredientAmount(String name, double amount) {
        ingredientList.remove(name);
        RecipeIngredient ri = new RecipeIngredient(name, amount);
        ingredientList.put(ri.GetName(), ri.GetAmount());
    }

    Map<String, Double> convertValue(double batchSize) {
        Map<String, Double> convertedIngredientList = new TreeMap<>();
        for (String key : ingredientList.keySet()) {
            convertedIngredientList.put(key, ingredientList.get(key) / (this.size) * batchSize);
        }
        return convertedIngredientList;
    }
}
