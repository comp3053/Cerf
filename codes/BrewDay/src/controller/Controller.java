package controller;

import javax.swing.JFrame;

import view.*;
import model.*;

public class Controller {
	private static Controller instance = new Controller();
	private MainPage mainPage;
	private RecipeListPage recipeListPage;
	private IngredientListPage ingredientListPage;
	private EquipmentListPage equipmentListPage;
	
	public Controller() {
		Init();
	}
	
	public void Init() {
		mainPage = new MainPage();
	}
	
	public void ToMainPage(JFrame frame) {
		mainPage = new MainPage();
		frame.dispose();
	}
	
	public void ToRecipeListPage(JFrame frame) {
		recipeListPage = new RecipeListPage();
		frame.dispose();
	}
	
	public void ToIngredientListPage(JFrame frame) {
		ingredientListPage = new IngredientListPage();
		frame.dispose();
	}
	
	public void ToEquipmentListPage(JFrame frame) {
		equipmentListPage = new EquipmentListPage();
		frame.dispose();
	}
	
	public static Controller GetInstance() {
		return instance;
	}
}
