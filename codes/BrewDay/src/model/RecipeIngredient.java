package model;

public class RecipeIngredient extends Ingredient{
	RecipeIngredient(String name, double amount, String unit) {
		super(name, amount, unit);
	}

	public void UpdateAmount(double amount) {
		this.SetAmount(amount);
	}
}
