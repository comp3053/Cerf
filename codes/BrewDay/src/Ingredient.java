
public class Ingredient {
	private String name;
	private double amount;
	//private String unit;
	
	Ingredient(String name, double amount){
		this.name = name;
		this.amount = amount;
	}
	
	String GetName() {
		return this.name;
	}
	
	double GetAmount() {
		return this.amount;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	void SetAmount(double amount) {
		this.amount = amount;
	}
}
