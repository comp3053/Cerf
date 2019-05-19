package model;

public class StorageIngredient extends Ingredient {
    public StorageIngredient(String name, double amount, String unit) {
        super(name, amount, unit);
    }

    public void AddAmount(double amount) {
        this.setAmount(this.getAmount() + amount);
    }

    public void SubtractAmount(double amount) {
        this.setAmount(this.getAmount() - amount);
    }
}
