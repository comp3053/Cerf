package model;

import controller.Controller;

class BrewDay {

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
        Controller controller = Controller.GetInstance();
    }
}