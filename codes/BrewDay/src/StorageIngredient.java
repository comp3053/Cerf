public class StorageIngredient extends Ingredient {
    StorageIngredient(String name, double amount) {
        super(name, amount);
    }

    public void AddAmount(double amount) {
        this.SetAmount(this.GetAmount() + amount);
    }

    public void SubtractAmount(double amount) {
        this.SetAmount(this.GetAmount() - amount);
    }
}
