package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class RecipeListPage extends JFrame{
	private Controller controller;
	public RecipeListPage() {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("Recipe List",SwingConstants.CENTER);
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
        recipePanel.setPreferredSize(new Dimension(200,600));
        //recipePanel.setBackground(java.awt.Color.blue);
        JScrollPane scrollPane = new JScrollPane(recipePanel);
        
        /* ----- Button Recipe 1 (test) ----- */
        JButton recipeBtn1 = new JButton("Recipe 1");
        recipeBtn1.setPreferredSize(new Dimension(300,50));
        recipeBtn1.setEnabled(true);
        
        /* ----- Button Recipe 2 (test) ----- */
        JButton recipeBtn2 = new JButton("Recipe 2");
        recipeBtn2.setPreferredSize(new Dimension(300,50));
        recipeBtn2.setEnabled(true);

        /* ----- Button Recipe 3 (test) ----- */
        JButton recipeBtn3 = new JButton("Recipe 3");
        recipeBtn3.setPreferredSize(new Dimension(300,50));
        recipeBtn3.setEnabled(true);
        
        /* ----- Button Recipe 4 (test) ----- */
        JButton recipeBtn4 = new JButton("Recipe 4");
        recipeBtn4.setPreferredSize(new Dimension(300,50));
        recipeBtn4.setEnabled(true);
        
        /* ----- Button Recipe 5 (test) ----- */
        JButton recipeBtn5 = new JButton("Recipe 5");
        recipeBtn5.setPreferredSize(new Dimension(300,50));
        recipeBtn5.setEnabled(true);
        
        /* ----- Button Recipe 6 (test) ----- */
        JButton recipeBtn6 = new JButton("Recipe 6");
        recipeBtn6.setPreferredSize(new Dimension(300,50));
        recipeBtn6.setEnabled(true);

        /* ----- Button Recipe 7 (test) ----- */
        JButton recipeBtn7 = new JButton("Recipe 7");
        recipeBtn7.setPreferredSize(new Dimension(300,50));
        recipeBtn7.setEnabled(true);
        
        /* ----- Button Recipe 8 (test) ----- */
        JButton recipeBtn8 = new JButton("Recipe 8");
        recipeBtn8.setPreferredSize(new Dimension(300,50));
        recipeBtn8.setEnabled(true);
        
        recipePanel.add(recipeBtn1);
        recipePanel.add(recipeBtn2);
        recipePanel.add(recipeBtn3);
        recipePanel.add(recipeBtn4);
        recipePanel.add(recipeBtn5);
        recipePanel.add(recipeBtn6);
        recipePanel.add(recipeBtn7);
        recipePanel.add(recipeBtn8);

        
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
