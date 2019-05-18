package BrewDay;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;


public class BrewDay_GUI extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        //set the look and feel to 'Nimbus'
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals("Nimbus")) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
        new BrewDay_GUI();
    }


    // Constructor of ClientGUI
    private BrewDay_GUI() {
        JFrame frame = new JFrame("Client Chat Console");
        frame.setResizable(false);
        // Forbidden window resize (maximize)

        Container container = getContentPane();

        JButton msgBtn = new JButton("Send ");
        msgBtn.setEnabled(true);

        JButton aBtn = new JButton("A ");
        msgBtn.setEnabled(true);

        JButton bBtn = new JButton("B ");
        msgBtn.setEnabled(true);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        buttonPanel.add(msgBtn);
        buttonPanel.add(aBtn);
        buttonPanel.add(bBtn);

        //Dimension newDim = new Dimension(450, 200);

        container.add(buttonPanel, BorderLayout.CENTER);

        frame.add(container);
        frame.setBackground(Color.white);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setLocation(150, 150);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
