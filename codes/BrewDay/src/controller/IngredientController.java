package controller;

import java.util.ArrayList;

import model.BrewData;
import model.StorageIngredient;

public class IngredientController {
	private static IngredientController instance = new IngredientController();
	private BrewData brewData;
	private ArrayList<StorageIngredient> storageIngredientList;
	
	public IngredientController() {
		
	}

    public static IngredientController GetInstance() {
        return instance;
    }
	
	public void addIngredient(String name, double amount, String unit) {
		StorageIngredient newIngre = new StorageIngredient(name,amount,unit);
		brewData = new BrewData();
		storageIngredientList = brewData.getStorageIngredientList();
		storageIngredientList.add(newIngre);
		brewData.setStorageIngredientList(storageIngredientList);
	}
}
