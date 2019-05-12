
public class Ingredient {
	private String name;
	private double amount;
	//private String unit;
	
	public Ingredient(String name,double amount){
		this.name = name;
		this.amount = amount;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public double GetAmount() {
		return this.amount;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetAmount(double amount) {
		this.amount = amount;
	}
}
