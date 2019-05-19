package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

class ViewNotePage extends JFrame {
    private Controller controller;
    private String noteContent;
    //private Date noteDate;

    ViewNotePage() {
        JFrame frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Notes:", SwingConstants.CENTER);
        titlePanel.add(pageTitle);


        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));

        JButton backBtn = new JButton("Back");
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.addActionListener(e -> {
            new NotePage();
            frame.dispose();
        });

        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(backBtn);
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());
        motionPanel.add(new JLabel());

        /* ---------- Content Panel ---------- */
        JPanel notePanel = new JPanel(new BorderLayout());
        notePanel.setPreferredSize(new Dimension(200, 600));
        //ingredientPanel.setBackground(java.awt.Color.blue);

        JTextPane notePane = new JTextPane();
        //SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        notePane.setText(noteContent);
        notePane.setEditable(false);

        JScrollPane listScrollPane = new JScrollPane(notePane);
        notePanel.add(listScrollPane, BorderLayout.CENTER);

        container.add(notePanel, BorderLayout.CENTER);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(blankPanelR, BorderLayout.EAST);
        container.add(blankPanelL, BorderLayout.WEST);
        container.add(motionPanel, BorderLayout.SOUTH);

        frame.add(container);
        frame.setResizable(false);
        frame.setSize(new Dimension(600, 800));
        frame.setLocation(150, 150);
        //frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    /*
    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }
    */
}
