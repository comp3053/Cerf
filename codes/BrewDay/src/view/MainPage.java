package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private Controller controller;

    // Constructor of MainPage
    public MainPage() {
        JFrame frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Brew Day !", SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- Content Panel ---------- */
        JPanel buttonPanel = new JPanel(new GridLayout(10, 1));

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(150, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(150, 100));

        /* ----- Button Recipe List ----- */
        JButton recipeBtn = new JButton("Recipe List");
        recipeBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getRecipeListPage(frame);
        });
        recipeBtn.setEnabled(true);

        /* ----- Button Ingredient List ----- */
        JButton ingredientBtn = new JButton("Ingredient List");
        ingredientBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getIngredientListPage(frame);
        });
        ingredientBtn.setEnabled(true);

        /* ----- Button Equipment List ----- */
        JButton equipmentBtn = new JButton("Equipment List");
        equipmentBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getEquipmentListPage(frame);
        });
        equipmentBtn.setEnabled(true);

        /* ----- Button NotePage ----- */
        JButton noteBtn = new JButton("Notes");
        noteBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getNotePage(frame);
        });
        noteBtn.setEnabled(true);

        buttonPanel.add(new JLabel());
        buttonPanel.add(recipeBtn);
        buttonPanel.add(new JLabel());
        buttonPanel.add(ingredientBtn);
        buttonPanel.add(new JLabel());
        buttonPanel.add(equipmentBtn);
        buttonPanel.add(new JLabel());
        buttonPanel.add(noteBtn);
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());

        container.add(buttonPanel, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(blankPanelR, BorderLayout.EAST);

        frame.add(container);
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 800));
        frame.setLocation(150, 150);
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
