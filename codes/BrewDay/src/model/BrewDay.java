package model;

import controller.*;

public class BrewDay {
	private Controller controller;
	
	public BrewDay() {
		init();
	}
	
	public void init() {
		controller = Controller.GetInstance();
	}
	
	public static void main(String[] arg) {
		try {
			BrewDay bd = new BrewDay();
		}catch(Exception e) {
			System.out.println(e);
		}
    }
}