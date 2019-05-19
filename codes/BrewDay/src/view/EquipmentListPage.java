package view;

import controller.Controller;
import model.BrewData;
import model.Equipment;
import model.StorageIngredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipmentListPage extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Controller controller;
    private JFrame frame;
    private BrewData brewData;

    public EquipmentListPage() {
        frame = new JFrame("Brew Day !");

        Container container = getContentPane();

        /* ---------- Title Panel ---------- */
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setPreferredSize(new Dimension(600, 100));
        JLabel pageTitle = new JLabel("Equipment List", SwingConstants.CENTER);
        titlePanel.add(pageTitle);

        /* ---------- blank Panel ---------- */
        JPanel blankPanelL = new JPanel(new BorderLayout());
        blankPanelL.setPreferredSize(new Dimension(100, 100));
        JPanel blankPanelR = new JPanel(new BorderLayout());
        blankPanelR.setPreferredSize(new Dimension(100, 100));

        /* ---------- motion Panel ---------- */
        JPanel motionPanel = new JPanel(new GridLayout(3, 5));
        motionPanel.setPreferredSize(new Dimension(100, 100));
        JButton addBtn = new JButton("Add");
        addBtn.setPreferredSize(new Dimension(100, 50));
        addBtn.addActionListener(e -> {
    		controller = Controller.GetInstance();
    		controller.getAddEquipmentPage(frame);
    	});
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
        JPanel equipmentPanel = new JPanel(new BorderLayout());
        equipmentPanel.setPreferredSize(new Dimension(200, 600));
        
        JList<String> jList = new JList<>();

        DefaultListModel<String> listModel = new DefaultListModel<>();

        brewData = new BrewData();
        
        for(Equipment e : brewData.GetEquipmentList()) {
        	String equipment = e.GetName() + "    " + e.GetSize();
        	listModel.addElement(equipment);
        }

        jList.setModel(listModel);

        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (e.getClickCount() == 2) {
                        int index = jList.getSelectedIndex();
                        Equipment equipment = brewData.GetEquipmentList().get(index);
                        controller = Controller.GetInstance();
                        controller.getEditEquipmentPage(frame,equipment);
                    }
                }
            }
        });

        JScrollPane listScrollPane = new JScrollPane(jList);
        equipmentPanel.add(listScrollPane, BorderLayout.CENTER);

        container.add(equipmentPanel, BorderLayout.CENTER);
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

    public void actionPerformed(ActionEvent e) {
        //equipmentDetailPage.setEquipName(e.getActionCommand());
        // frame.dispose();
        BrewData brewData = new BrewData();
        ArrayList<Equipment> equipmentList = brewData.getEquipmentList();
        for (Equipment equipment : equipmentList) {
            if (equipment.GetName().equals(e.getActionCommand())) {
                new EquipmentDetailPage(equipment);
            }
        }
    }
}
