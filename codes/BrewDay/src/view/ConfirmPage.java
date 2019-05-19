package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import controller.Controller;
import model.BrewData;

public class ConfirmPage extends JFrame{
	private Controller controller;
	private BrewData brewData;
	
	public ConfirmPage(int situation) {
        JFrame frame = new JFrame("Confirm");
        
        Container container = getContentPane();
        
        JPanel contentPanel = new JPanel(new FlowLayout());
        
        JPanel textPanel = new JPanel(new FlowLayout());
        textPanel.setPreferredSize(new Dimension(300,50));
        JLabel content = new JLabel("Are you sure to ",SwingConstants.CENTER);
        
        textPanel.add(content);
        
        JPanel btnPanel = new JPanel(new GridLayout(3,5));
        JButton yesBtn = new JButton("Yes");
        JButton noBtn = new JButton("No");
        
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        
        btnPanel.add(new JLabel());
        btnPanel.add(yesBtn);
        btnPanel.add(new JLabel());
        btnPanel.add(noBtn);
        btnPanel.add(new JLabel());
        
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        btnPanel.add(new JLabel());
        
        contentPanel.add(textPanel);
        contentPanel.add(btnPanel);
        
        container.add(contentPanel);
        
        frame.add(container);
        frame.setResizable(false);					//Forbid window resize (maximize)
        frame.setSize(new Dimension(300,200));		//set window size
        frame.setLocation(150, 150);				//set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
	}
	
}
