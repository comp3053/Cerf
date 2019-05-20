package controller;

import model.BrewData;
import model.Equipment;
import model.StorageIngredient;

import java.util.ArrayList;

public class EquipmentController {
    private static final EquipmentController instance = new EquipmentController();

    private EquipmentController() {

    }

    public static EquipmentController GetInstance() {
        return instance;
    }

    public void addEquipment(String name, double amount) {
//        System.out.println("name : " + name + " amount : " + amount + " unit : " + unit);
        Equipment newEquip = new Equipment(name, amount);
        ArrayList<Equipment> equipmentList = BrewData.getEquipmentList();
        equipmentList.add(newEquip);
        BrewData.setEquipmentList(equipmentList);;
    }
    
    public void editEquipment(Equipment e,String name, double amount) {
    	
    	Equipment newEquip = new Equipment(name, amount);
    	ArrayList<Equipment> equipmentList = BrewData.getEquipmentList();
    	equipmentList.remove(e);
    	equipmentList.add(newEquip);
    	BrewData.setEquipmentList(equipmentList);;
    }
}
