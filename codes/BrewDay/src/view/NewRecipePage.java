package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.Controller;
import model.BrewData;
import model.Recipe;
import model.RecipeIngredient;

public class NewRecipePage extends JFrame{
	private Controller controller;
	private BrewData brewData;
	
	public NewRecipePage() {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("New Recipe",SwingConstants.CENTER);
        titlePanel.add(pageTitle);
        
        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100,100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100,100));
        
        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3,5));
        motionPanel.setPreferredSize(new Dimension(100,100));
        JButton saveBtn = new JButton("SAVE");
        saveBtn.setPreferredSize(new Dimension(100,50));
        saveBtn.addActionListener(e -> {
    		controller = Controller.GetInstance();
    		controller.getRecipeListPage(frame);
    	});
        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100,50));
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
        
        
        /* ---------- Content Panel ---------- */
        JPanel recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(300,600));
        
        brewData = new BrewData();
        
        JPanel recipeNamePane = new JPanel();
        recipeNamePane.setPreferredSize(new Dimension(200,100));
        JLabel recipeName = new JLabel("Recipe Name :");
        JTextPane recipeNameBox = new JTextPane();
        recipeNameBox.setPreferredSize(new Dimension(100,20));
        recipeNamePane.add(recipeName);
        recipeNamePane.add(recipeNameBox);
        
        JPanel recipeContentPane = new JPanel();
        recipeContentPane.setPreferredSize(new Dimension(300,100));
        JLabel name = new JLabel("Name:");
        JTextPane nameBox = new JTextPane();
        nameBox.setPreferredSize(new Dimension(50,20));
        JLabel amount = new JLabel("Amount:");
        JTextPane amountBox = new JTextPane();
        amountBox.setPreferredSize(new Dimension(30,20));
        JComboBox<String> unit = new JComboBox<String>();
        unit.addItem("ml");
        unit.addItem("g");
        
        recipeContentPane.add(name);
        recipeContentPane.add(nameBox);
        recipeContentPane.add(amount);
        recipeContentPane.add(amountBox);
        recipeContentPane.add(unit);
        
        recipePanel.add(recipeNamePane,BorderLayout.CENTER);
        recipePanel.add(recipeContentPane,BorderLayout.CENTER);
        
        
        container.add(recipePanel, BorderLayout.CENTER);
        container.add(titlePanel,BorderLayout.NORTH);
        container.add(blankPanelR,BorderLayout.EAST);
        container.add(blankPanelL,BorderLayout.WEST);
        container.add(motionPanel,BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(600,800));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
	}
}