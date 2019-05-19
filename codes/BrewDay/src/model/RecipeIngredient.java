package model;

public class RecipeIngredient extends Ingredient {
    public RecipeIngredient(String name, double amount, String unit) {
        super(name, amount, unit);
    }

    public void UpdateAmount(double amount) {
        this.setAmount(amount);
    }
}
