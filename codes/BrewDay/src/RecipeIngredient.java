
public class RecipeIngredient extends Ingredient{
	public RecipeIngredient(String name, double amount) {
		super(name, amount);
	}

	public void UpdateAmount(double amount) {
		this.SetAmount(amount);
	}
}
