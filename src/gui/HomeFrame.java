/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui;

import src.backend.Composition;
import src.backend.Library;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
/**
 *
 * @author Michael Tu
 */
public class HomeFrame extends JPanel {

    private JButton addButton;
    private JButton autocompleteButton;
    private JLabel directions;
    private JButton importButton;
    private JButton viewButton;
    private JLabel welcomeMessage;

    private static final Library LIBRARY = new Library(new File("C:/Users/Michael Tu/Desktop/Code/IA/Database.xlsx"));;

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMessage = new JLabel();
        directions = new JLabel();
        importButton = new JButton();
        addButton = new JButton();
        viewButton = new JButton();
        autocompleteButton = new JButton();

        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setText("Welcome Mr. Kelly to the Orchestra Music Library Creator!");

        directions.setText("Select a button below to get started.");

        importButton.setText("Import Library");
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                importButtonActionPerformed(evt);
            }

            private void importButtonActionPerformed(ActionEvent evt) 
            {
                ImportFrame impF = new ImportFrame(LIBRARY);
                JFrame frame = new JFrame("Import Composition");
        
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(impF, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
        
                // System.out.println(LIBRARY);
            }
        });

        addButton.setText("Add music");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }

            private void addButtonActionPerformed(ActionEvent evt) 
            {
                EditFrame ef = new EditFrame(LIBRARY);
                JFrame frame = new JFrame("Add Composition");
        
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(ef, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        viewButton.setText("View Library");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }

            private void viewButtonActionPerformed(ActionEvent evt) 
            {
                ViewFrame vf = new ViewFrame(LIBRARY);
                JFrame frame = new JFrame("View Library");
        
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(vf, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        autocompleteButton.setText("Input using title");
        autocompleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                autocompleteButtonActionPerformed(evt);
            }

            private void autocompleteButtonActionPerformed(ActionEvent evt) 
            {
                AutocompleteFrame af = new AutocompleteFrame(LIBRARY);
                JFrame frame = new JFrame("View LIBRARY");
        
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(af, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(importButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(autocompleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(welcomeMessage)
                            .addComponent(directions))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeMessage)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(directions)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(addButton)
                    .addComponent(viewButton)
                    .addComponent(autocompleteButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("HomeFrame");

        frame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                SavePrompt sp = new SavePrompt(LIBRARY);
                sp.setVisible(true);
            }});

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HomeFrame(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
