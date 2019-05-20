package view;

import controller.Controller;
import controller.RecipeController;
import model.BrewData;
import model.Recipe;
import model.RecipeIngredient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeDetailPage extends JFrame {
    private Controller controller;
    private RecipeController rController;

    public RecipeDetailPage(Recipe recipe) {
        JFrame frame = new JFrame("Brew Day!");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel(recipe.getRecipeName(), SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 7));
        motionPanel.setPreferredSize(new Dimension(100, 100));

        JButton saveBtn = new JButton("SAVE");
        saveBtn.setPreferredSize(new Dimension(100, 50));

        JButton deleteBtn = new JButton("DELETE");
        deleteBtn.setPreferredSize(new Dimension(100, 50));
        deleteBtn.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure to delete?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                ArrayList<Recipe> recipeList = BrewData.getRecipeList();
                recipeList.remove(recipe);
                BrewData.setRecipeList(recipeList);
                new RecipeListPage();
                frame.dispose();
            }
        });

        JButton useBtn = new JButton("Use");
        useBtn.setPreferredSize(new Dimension(100, 50));
        useBtn.addActionListener(e -> {
            rController = RecipeController.GetInstance();
            System.out.println(rController.implement(recipe));
            controller = Controller.GetInstance();
            controller.getRecipeListPage(frame);
        });
        
        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.addActionListener(e -> {
            controller = Controller.GetInstance();
            controller.getRecipeListPage(frame);
        });

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());

        motionPanel.add(saveBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(deleteBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(useBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());


        /* ---------- Content Panel ---------- */
        JPanel recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(200, 600));

        JList<String> jList = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (RecipeIngredient ri : recipe.GetIngredientList()) {
            String ingredient = ri.getName() + "    " + ri.getAmount() + ri.getUnit();
            listModel.addElement(ingredient);
        }

        jList.setModel(listModel);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(jList);
        recipePanel.add(listScrollPane, BorderLayout.CENTER);

        container.add(recipePanel, BorderLayout.CENTER);
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