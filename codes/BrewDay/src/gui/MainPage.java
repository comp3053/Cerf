package gui;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
	
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
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        
        /* ----- Button Recipe List ----- */
        JButton recipeBtn = new JButton("Recipe List");
        recipeBtn.setEnabled(true);

        /* ----- Button Ingredient List ----- */
        JButton ingredientBtn = new JButton("Ingredient List");
        ingredientBtn.setEnabled(true);

        /* ----- Button Equipment List ----- */
        JButton equipmentBtn = new JButton("Equipment List");
        equipmentBtn.setEnabled(true);

        /* ----- Button Note ----- */
        JButton noteBtn = new JButton("Notes");
        noteBtn.setEnabled(true);
        
        
        buttonPanel.add(recipeBtn);
        buttonPanel.add(ingredientBtn);
        buttonPanel.add(equipmentBtn);
        buttonPanel.add(noteBtn);
        
        
        
        container.add(buttonPanel, BorderLayout.CENTER);
        container.add(titlePanel,BorderLayout.NORTH);

        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(600,800));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
