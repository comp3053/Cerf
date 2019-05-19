package view;


import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IngredientListPage extends JFrame {
    private Controller controller;

    public IngredientListPage() {
        JFrame frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Ingredient List", SwingConstants.CENTER);
        titlePanel.add(pageTitle);


        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));
        JButton addBtn = new JButton("ADD");
        addBtn.setPreferredSize(new Dimension(100, 50));
        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
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
        JPanel ingredientPanel = new JPanel(new BorderLayout());
        ingredientPanel.setPreferredSize(new Dimension(200, 600));

        JList<String> jList = new JList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        listModel.addElement("dddd");

        jList.setModel(listModel);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String noteContent = jList.getSelectedValue();
                    NoteDetailPage noteDetailPage = new NoteDetailPage();
                    noteDetailPage.setNoteContent(noteContent);
                }
            }
        });

        JScrollPane listScrollPane = new JScrollPane(jList);
        ingredientPanel.add(listScrollPane, BorderLayout.CENTER);

        container.add(ingredientPanel, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);                    //Forbid window resize (maximize)
        frame.setSize(new Dimension(600, 800));        //set window size
        frame.setLocation(150, 150);                //set location
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
