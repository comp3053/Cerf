package controller;

import java.util.ArrayList;

import model.BrewData;
import model.StorageIngredient;

public class IngredientController {
	private static IngredientController instance = new IngredientController();
	private ArrayList<StorageIngredient> storageIngredientList;
	
	public IngredientController() {
		
	}

    public static IngredientController GetInstance() {
        return instance;
    }
	
	public void addIngredient(String name, double amount, String unit) {
		System.out.println("name : " + name + " amount : " + amount + " unit : " + unit);
		StorageIngredient newIngre = new StorageIngredient(name,amount,unit);
		storageIngredientList = BrewData.getStorageIngredientList();
		storageIngredientList.add(newIngre);
		BrewData.setStorageIngredientList(storageIngredientList);
	}
}
