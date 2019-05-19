package model;

public class Ingredient {
	private String name;
	private double amount;
	private String unit;
	
	Ingredient(String name, double amount, String unit){
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public double GetAmount() {
		return this.amount;
	}
	
	public String GetUnit() {
		return this.unit;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetAmount(double amount) {
		this.amount = amount;
	}
	
	public void SetUnit(String unit) {
		this.unit = unit;
	}
}
