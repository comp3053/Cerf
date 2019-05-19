package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.Controller;
import model.*;

public class RecipeDetailPage extends JFrame{
	private Controller controller;
	private BrewData brewData;
	
	public RecipeDetailPage(Recipe recipe) {
        JFrame frame = new JFrame("Brew Day !");
        
        Container container = getContentPane();
        
        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600,100));
        JLabel pageTitle = new JLabel(recipe.GetRecipeName(),SwingConstants.CENTER);
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
        		controller.getRecipeListPage(frame);
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
        
        brewData = new BrewData();
        
        JList<String> jList = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for(RecipeIngredient ri : recipe.GetIngredientList()) {
        	String ingredient = ri.GetName() + "    " + ri.GetAmount() + ri.GetUnit();
        	listModel.addElement(ingredient);
        }

        jList.setModel(listModel);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(jList);
        recipePanel.add(listScrollPane, BorderLayout.CENTER);
        
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