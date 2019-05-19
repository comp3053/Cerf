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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.Controller;
import controller.IngredientController;
import model.BrewData;

public class AddIngredientsPage extends JFrame {
	private Controller controller;
	private IngredientController ingreController;
	private BrewData brewData;
	
	public AddIngredientsPage() {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("Add Ingredients",SwingConstants.CENTER);
        titlePanel.add(pageTitle);
        
        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100,100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100,100));
        
        
        /* ---------- Content Panel ---------- */
        JPanel ingredientPanel = new JPanel(new FlowLayout());
        ingredientPanel.setPreferredSize(new Dimension(300,600));
        
        brewData = new BrewData();
        
        JPanel namePane = new JPanel();
        namePane.setPreferredSize(new Dimension(200,100));
        JLabel name = new JLabel("Ingredient Name :");
        JTextPane nameBox = new JTextPane();
        nameBox.setPreferredSize(new Dimension(100,20));
        namePane.add(name);
        namePane.add(nameBox);
        
        JPanel amountPane = new JPanel();
        amountPane.setPreferredSize(new Dimension(300,100));
        JLabel amount = new JLabel("Amount :");
        JTextPane amountBox = new JTextPane();
        amountBox.setPreferredSize(new Dimension(100,20));
        JComboBox<String> unit = new JComboBox<String>();
        unit.addItem("ml");
        unit.addItem("g");
        
        amountPane.add(amount);
        amountPane.add(amountBox);
        amountPane.add(unit);
        
        ingredientPanel.add(namePane,BorderLayout.CENTER);
        ingredientPanel.add(amountPane,BorderLayout.CENTER);
        
        
        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3,5));
        motionPanel.setPreferredSize(new Dimension(100,100));
        JButton saveBtn = new JButton("SAVE");
        saveBtn.setPreferredSize(new Dimension(100,50));
        saveBtn.addActionListener(e -> {
        	ingreController = IngredientController.GetInstance();
        	String ingreName = nameBox.getText();
        	double ingreAmount = Double.valueOf(amountBox.getText().toString());
        	String ingreUnit = (String) unit.getSelectedItem();
        	ingreController.addIngredient(ingreName,ingreAmount,ingreUnit);
        	
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
        
        
        container.add(ingredientPanel, BorderLayout.CENTER);
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
