package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

public class MainPage extends JFrame {
	private Controller controller;
    // Constructor of MainPage
    public MainPage() {
        JFrame frame = new JFrame("Brew Day !");
       
        Container container = getContentPane();
        
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("Brew Day !",SwingConstants.CENTER);
        titlePanel.add(pageTitle);
        
        /* ---------- Content Panel ---------- */
        JPanel buttonPanel = new JPanel(new GridLayout(10,1));
        
        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(150,100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(150,100));
        
        /* ----- Button Recipe List ----- */
        JButton recipeBtn = new JButton("Recipe List");
        recipeBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller = Controller.GetInstance();
        		controller.ToRecipeListPage(frame);
        	}
        });
        recipeBtn.setEnabled(true);

        /* ----- Button Ingredient List ----- */
        JButton ingredientBtn = new JButton("Ingredient List");
        ingredientBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller = Controller.GetInstance();
        		controller.ToIngredientListPage(frame);
        	}
        });
        ingredientBtn.setEnabled(true);

        /* ----- Button Equipment List ----- */
        JButton equipmentBtn = new JButton("Equipment List");
        equipmentBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller = Controller.GetInstance();
        		controller.ToEquipmentListPage(frame);
        	}
        });
        equipmentBtn.setEnabled(true);

        /* ----- Button Note ----- */
        JButton noteBtn = new JButton("Notes");
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
        container.add(titlePanel,BorderLayout.NORTH);
        container.add(blankPanelL,BorderLayout.WEST);
        container.add(blankPanelR,BorderLayout.EAST);

        
        
        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(600,800));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
