
public class StorageIngredient extends Ingredient {

	public StorageIngredient(String name, double amount) {
		super(name, amount);
		// TODO Auto-generated constructor stub
	}

	public void AddAmount(double amount) {
		this.SetAmount(this.GetAmount() + amount);
	}
	
	public void SubtractAmount(double amount) {
		this.SetAmount(this.GetAmount() - amount);
	}
}
