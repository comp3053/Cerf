package view;

import model.BrewData;
import model.Equipment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class EquipmentDetailPage extends JFrame {
    EquipmentDetailPage(Equipment equipment) {
        JFrame frame = new JFrame("Brew Day!");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Equipment Detail", SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setPreferredSize(new Dimension(100, 50));
        deleteBtn.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure to delete?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                ArrayList<Equipment> equipmentList = BrewData.getEquipmentList();
                equipmentList.remove(equipment);
                BrewData.setEquipmentList(equipmentList);
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.addActionListener(e -> frame.dispose());

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(deleteBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());


        /* ---------- Content Panel ---------- */
        JPanel equipPanel = new JPanel(new BorderLayout());
        equipPanel.setPreferredSize(new Dimension(200, 600));
        //ingredientPanel.setBackground(java.awt.Color.blue);

        JTextPane equipPane = new JTextPane();
        //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

        equipPane.setEditable(false);

        JScrollPane listScrollPane = new JScrollPane(equipPane);
        equipPanel.add(listScrollPane, BorderLayout.CENTER);

        container.add(equipPanel, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);                    //Forbid window resize (maximize)
        frame.setSize(new Dimension(600, 800));        //set window size
        frame.setLocation(250, 0);                //set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
