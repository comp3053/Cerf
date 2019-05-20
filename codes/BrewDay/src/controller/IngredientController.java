package controller;

import model.BrewData;
import model.StorageIngredient;

import java.util.ArrayList;

public class IngredientController {
    private static final IngredientController instance = new IngredientController();

    private IngredientController() {

    }

    public static IngredientController GetInstance() {
        return instance;
    }

    public void addIngredient(String name, double amount, String unit) {
//        System.out.println("name : " + name + " amount : " + amount + " unit : " + unit);
        StorageIngredient newIngre = new StorageIngredient(name, amount, unit);
        ArrayList<StorageIngredient> storageIngredientList = BrewData.getStorageIngredientList();
        storageIngredientList.add(newIngre);
        BrewData.setStorageIngredientList(storageIngredientList);
    }
}
