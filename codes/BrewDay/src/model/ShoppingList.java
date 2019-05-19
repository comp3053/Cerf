package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingList {
	private ArrayList<Ingredient> shoppingList;
	public ShoppingList() {
		shoppingList = new ArrayList<Ingredient>();
	}
	
	public ArrayList<Ingredient> getShoppingList(){
		return this.shoppingList;
	}
}
