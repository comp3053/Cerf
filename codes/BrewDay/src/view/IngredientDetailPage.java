package view;


import model.BrewData;
import model.StorageIngredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class IngredientDetailPage extends JFrame implements ActionListener {
    private final JTextField nameField = new JTextField();
    private final JTextField amountField = new JTextField();
    private final JButton saveBtn;
    private final StorageIngredient ingredient;

    IngredientDetailPage(StorageIngredient nIngredient) {
        JFrame frame = new JFrame("Brew Day!");
        ingredient = nIngredient;

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel(ingredient.getName(), SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 7));
        motionPanel.setPreferredSize(new Dimension(100, 100));

        saveBtn = new JButton("Save");
        saveBtn.setPreferredSize(new Dimension(100, 50));
        saveBtn.addActionListener(this);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setPreferredSize(new Dimension(100, 50));
        deleteBtn.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Are you sure to delete?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                ArrayList<StorageIngredient> ingredientList = BrewData.getStorageIngredientList();
                ingredientList.remove(ingredient);
                BrewData.setStorageIngredientList(ingredientList);
                new IngredientListPage();
                frame.dispose();
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
        motionPanel.add(new JLabel());

        motionPanel.add(saveBtn);
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
        motionPanel.add(new JLabel());


        /* ---------- Content Panel ---------- */
        JPanel ingredientPanel = new JPanel(new FlowLayout());
        ingredientPanel.setPreferredSize(new Dimension(200, 600));
        //ingredientPanel.setBackground(java.awt.Color.blue);

        //JPanel ingredientPanel = new JPanel(new FlowLayout());

        JScrollPane listScrollPane = new JScrollPane(ingredientPanel);

        ingredientPanel.add(nameField);
        ingredientPanel.add(amountField);
        JTextField unitField = new JTextField();
        ingredientPanel.add(unitField);

        container.add(listScrollPane, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 800));
        frame.setLocation(250, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            String name = nameField.getText();
            double amount = Double.parseDouble(amountField.getText());
            //String unit = unitField.getText();
            StorageIngredient newIngredient = new StorageIngredient(name, amount, ingredient.getUnit());
            ArrayList<StorageIngredient> storageIngredientList = BrewData.getStorageIngredientList();
            storageIngredientList.remove(ingredient);
            storageIngredientList.add(newIngredient);
        }
    }
}
