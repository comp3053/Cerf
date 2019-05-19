package model;

import controller.*;

public class BrewDay {
	private Controller controller;
	
	private BrewDay() {
		init();
	}
	
	private void init() {
		controller = Controller.GetInstance();
	}
	
	public static void main(String[] arg) {
		try {
			new BrewDay();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
}