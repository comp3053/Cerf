package view;

import controller.Controller;
import controller.RecipeController;
import model.Recipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class RecommendPage extends JFrame {
    private Controller controller;
    private Recipe recipe;
    private JFrame frame;
    private JPanel recipePanel;

    RecommendPage() {
        frame = new JFrame("Brew Day!");

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
        JButton recmBtn = new JButton("Recommend");
        recmBtn.setPreferredSize(new Dimension(100, 50));
        recmBtn.addActionListener(e -> {
            double amount = Double.valueOf(JOptionPane.showInputDialog(frame, "Pleas enter the amount:"));
            RecipeController recipeController = RecipeController.GetInstance();
            ArrayList<Recipe> recipeList = recipeController.recommend(amount);
            JButton[] btnArray = new JButton[recipeList.size()];

            for (int i = 0; i < recipeList.size(); i++) {
                recipe = recipeList.get(i);
                btnArray[i] = new JButton(recipe.getRecipeName());
                btnArray[i].setPreferredSize(new Dimension(300, 50));

                btnArray[i].addActionListener(ee -> {
                    controller = Controller.GetInstance();
                    controller.getRecipeDetialPage(frame, recipe);
                });

                recipePanel.add(btnArray[i]);
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.addActionListener(e -> {
            new RecipeListPage();
            frame.dispose();
        });

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(recmBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());


        /* ---------- Content Panel ---------- */
        recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(200, 600));
        JScrollPane scrollPane = new JScrollPane(recipePanel);

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
