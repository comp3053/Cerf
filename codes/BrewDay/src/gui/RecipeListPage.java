package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class RecipeListPage extends JFrame{
	
	public RecipeListPage() {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel("Recipe List",SwingConstants.CENTER);
        titlePanel.add(pageTitle);
        
        /* ---------- Content Panel ---------- */
        JPanel recipePanel = new JPanel(new FlowLayout());
        recipePanel.setPreferredSize(new Dimension(50,600));
        JScrollPane scrollPane = new JScrollPane(recipePanel);
        
        /* ----- Button Recipe 1 (test) ----- */
        JButton recipeBtn1 = new JButton("Recipe List");
        recipeBtn1.setEnabled(true);
        
        /* ----- Button Recipe 2 (test) ----- */
        JButton recipeBtn2 = new JButton("Recipe List");
        recipeBtn2.setEnabled(true);

        /* ----- Button Recipe 3 (test) ----- */
        JButton recipeBtn3 = new JButton("Recipe List");
        recipeBtn3.setEnabled(true);
        
        /* ----- Button Recipe 4 (test) ----- */
        JButton recipeBtn4 = new JButton("Recipe List");
        recipeBtn4.setEnabled(true);
        
        /* ----- Button Recipe 5 (test) ----- */
        JButton recipeBtn5 = new JButton("Recipe List");
        recipeBtn5.setEnabled(true);
        
        /* ----- Button Recipe 6 (test) ----- */
        JButton recipeBtn6 = new JButton("Recipe List");
        recipeBtn6.setEnabled(true);

        /* ----- Button Recipe 7 (test) ----- */
        JButton recipeBtn7 = new JButton("Recipe List");
        recipeBtn7.setEnabled(true);
        
        /* ----- Button Recipe 8 (test) ----- */
        JButton recipeBtn8 = new JButton("Recipe List");
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

        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(600,800));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
	}
}
