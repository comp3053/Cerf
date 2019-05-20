package view;

import controller.Controller;
import controller.RecipeController;
import model.RecipeIngredient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewRecipePage extends JFrame {
    private Controller controller;
    private RecipeController rController; 

    public NewRecipePage() {
        JFrame frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("New Recipe", SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));


        /* ---------- Content Panel ---------- */
        JPanel recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(300, 600));

        JPanel recipeNamePanel = new JPanel();
        recipeNamePanel.setPreferredSize(new Dimension(300, 100));
        JLabel recipeName = new JLabel("Recipe Name :");
        JTextPane recipeNameBox = new JTextPane();
        recipeNameBox.setPreferredSize(new Dimension(100, 20));
        recipeNamePanel.add(recipeName);
        recipeNamePanel.add(recipeNameBox);
        
        JPanel ingredientListPanel = new JPanel();
        ingredientListPanel.setPreferredSize(new Dimension(300, 400));
        
        JList<String> jList = new JList<>();
        
        jList.setPreferredSize(new Dimension(200,400));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        
        ArrayList<RecipeIngredient> ri = new ArrayList<RecipeIngredient>();
        ArrayList<String> showedList = new ArrayList<String>();
        
        for(RecipeIngredient r : ri) {
        	String ingredient = r.getName() + "    " + r.getAmount() + r.getUnit();
        	listModel.addElement(ingredient);
        }
        
        jList.setModel(listModel);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(jList);
        ingredientListPanel.add(listScrollPane, BorderLayout.CENTER);
        
        JPanel addPanel = new JPanel();
        addPanel.setPreferredSize(new Dimension(300, 100));
        JLabel name = new JLabel("Name:");
        JTextPane nameBox = new JTextPane();
        nameBox.setPreferredSize(new Dimension(50, 20));
        JLabel amount = new JLabel("Amount:");
        JTextPane amountBox = new JTextPane();
        amountBox.setPreferredSize(new Dimension(30, 20));
        JComboBox<String> unit = new JComboBox<String>();
        unit.addItem("ml");
        unit.addItem("g");
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            rController = RecipeController.GetInstance();
            
        	String ingreName = nameBox.getText();
        	double ingreAmount = Double.valueOf(amountBox.getText().toString());
        	String ingreUnit = (String) unit.getSelectedItem();

        	rController.addIngredient(ri, ingreName, ingreAmount, ingreUnit);
        	
        	jList.setModel(updateList(ri));
        });

        addPanel.add(name);
        addPanel.add(nameBox);
        addPanel.add(amount);
        addPanel.add(amountBox);
        addPanel.add(unit);
        addPanel.add(addBtn);

        recipePanel.add(recipeNamePanel, BorderLayout.NORTH);
        recipePanel.add(ingredientListPanel, BorderLayout.CENTER);
        recipePanel.add(addPanel,BorderLayout.SOUTH);
        
        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));
        JButton saveBtn = new JButton("SAVE");
        saveBtn.setPreferredSize(new Dimension(100, 50));
        saveBtn.addActionListener(e -> {
        	rController = RecipeController.GetInstance();
        	rController.addRecipe(ri, recipeNameBox.getText(), 1000);
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
        motionPanel.add(saveBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());

        
        container.add(recipePanel, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);                    //Forbid window resize (maximize)
        frame.setSize(new Dimension(600, 800));        //set window size
        frame.setLocation(250, 0);                //set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    
    public DefaultListModel<String> updateList(ArrayList<RecipeIngredient> ri){
    	DefaultListModel<String> updateModel = new DefaultListModel<String>();
    	
        for(RecipeIngredient r : ri) {
        	String ingredient = r.getName() + "    " + r.getAmount() + r.getUnit();
        	updateModel.addElement(ingredient);
        }
    	return updateModel;
    }
}