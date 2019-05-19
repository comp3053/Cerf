package view;


import controller.Controller;
import model.BrewData;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeListPage extends JFrame {
    private Controller controller;
    private BrewData brewData;
    private Recipe recipe;

    public RecipeListPage() {
        JFrame frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Recipe List", SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));
        JButton addBtn = new JButton("ADD");
        addBtn.setPreferredSize(new Dimension(100, 50));
        addBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getNewRecipePage(frame);
        });
        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getMainPage(frame);
        });

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(addBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());


        /* ---------- Content Panel ---------- */
        JPanel recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(200, 600));
        JScrollPane scrollPane = new JScrollPane(recipePanel);

        brewData = new BrewData();

        ArrayList<Recipe> recipeList = brewData.GetRecipeList();

        JButton[] btnArray = new JButton[recipeList.size()];

        for (int i = 0; i < recipeList.size(); i++) {
            recipe = recipeList.get(i);
            btnArray[i] = new JButton(recipe.GetRecipeName());
            btnArray[i].setPreferredSize(new Dimension(300, 50));

            btnArray[i].addActionListener(e -> {
                controller = Controller.GetInstance();
                controller.getRecipeDetialPage(frame, recipe);
            });

            recipePanel.add(btnArray[i]);
        }


        container.add(scrollPane, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);                    //Forbid window resize (maximize)
        frame.setSize(new Dimension(600, 800));        //set window size
        frame.setLocation(150, 150);                //set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
