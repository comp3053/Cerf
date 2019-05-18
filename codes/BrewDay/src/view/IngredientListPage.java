package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.Controller;

public class IngredientListPage extends JFrame {
	private Controller controller;
	public IngredientListPage() {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("Ingredient List",SwingConstants.CENTER);
        titlePanel.add(pageTitle);
        
        
        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100,100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100,100));
        
        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3,5));
        motionPanel.setPreferredSize(new Dimension(100,100));
        JButton addBtn = new JButton("ADD");
        addBtn.setPreferredSize(new Dimension(100,50));
        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100,50));
        backBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller = Controller.GetInstance();
        		controller.ToMainPage(frame);
        	}
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
        JPanel ingredientPanel = new JPanel(new FlowLayout());
        ingredientPanel.setPreferredSize(new Dimension(200,600));
        //ingredientPanel.setBackground(java.awt.Color.blue);
        JScrollPane scrollPane = new JScrollPane(ingredientPanel);
        
        /* ----- Button Ingredient 1 (test) ----- */
        JButton ingredientBtn1 = new JButton("Ingredient 1");
        ingredientBtn1.setPreferredSize(new Dimension(300,50));
        ingredientBtn1.setEnabled(true);
        
        /* ----- Button Ingredient 2 (test) ----- */
        JButton ingredientBtn2 = new JButton("Ingredient 2");
        ingredientBtn2.setPreferredSize(new Dimension(300,50));
        ingredientBtn2.setEnabled(true);

        /* ----- Button Ingredient 3 (test) ----- */
        JButton ingredientBtn3 = new JButton("Ingredient 3");
        ingredientBtn3.setPreferredSize(new Dimension(300,50));
        ingredientBtn3.setEnabled(true);
        
        /* ----- Button Ingredient 4 (test) ----- */
        JButton ingredientBtn4 = new JButton("Ingredient 4");
        ingredientBtn4.setPreferredSize(new Dimension(300,50));
        ingredientBtn4.setEnabled(true);
        
        
        ingredientPanel.add(ingredientBtn1);
        ingredientPanel.add(ingredientBtn2);
        ingredientPanel.add(ingredientBtn3);
        ingredientPanel.add(ingredientBtn4);


        
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(titlePanel,BorderLayout.NORTH);
        container.add(blankPanelR,BorderLayout.EAST);
        container.add(blankPanelL,BorderLayout.WEST);
        container.add(motionPanel,BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(600,800));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
	}
}
