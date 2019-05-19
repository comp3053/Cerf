package model;

import controller.Controller;

public class BrewDay {
    private Controller controller;

    private BrewDay() {
        init();
    }

    public static void main(String[] arg) {
        try {
            new BrewDay();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void init() {
        controller = Controller.GetInstance();
    }
}