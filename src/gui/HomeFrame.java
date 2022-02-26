/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui;

import src.backend.Library;

import java.awt.BorderLayout;
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
    private JButton helpButton;

    private static final Library LIBRARY = new Library(new File("Database.xlsx"));;

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
        helpButton = new JButton();
        JPanel homeFrame = this;

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
                impF.setVisible(true);
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

        Icon helpIcon = new ImageIcon("helpIcon.png");
        helpButton.setIcon(helpIcon);
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }

            private void helpButtonActionPerformed(ActionEvent evt) 
            {
                String str = "<html>\"Import library\": Overwrites the current library with an existing Excel file <br>"
                                + "\"Add music\": Adds a new composition<br>"
                                + "\"Input using title\": Searches the VBODA Database for a composition<br>"
                                + "\"View library\": View, edit, and delete compositions";
                // JDialog help = new JDialog();
                // JLabel instructions = new JLabel();

                // instructions.setText("<html>\"Import library\": Overwrites the current library with an existing Excel file <br>"
                //                         + "\"Add music\": Adds a new composition<br>"
                //                         + "\"Input using title\": Searches the VBODA Database for a composition<br>"
                //                         + "\"View library\": View, edit, and delete compositions");
                // instructions.setHorizontalAlignment(JLabel.CENTER);
                // help.add(instructions);

                // help.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                // help.setSize(500, 150);
                // System.out.println(help.getPreferredSize());
                // help.setLocationRelativeTo(null);
                // help.setVisible(true);

                JOptionPane.showMessageDialog(homeFrame, str);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(autocompleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewButton)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(welcomeMessage)
                            .addComponent(directions))
                        .addGap(36, 36, 36)
                        .addComponent(helpButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(welcomeMessage)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directions)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(addButton)
                    .addComponent(viewButton)
                    .addComponent(autocompleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("HomeFrame");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().add(new HomeFrame(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) 
            {
                Object[] options = {"Save", "Don't Save"};
                int result = JOptionPane.showOptionDialog(frame, "Do you want to save?", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                switch (result)
                {
                    case 0:
                        SavePrompt sp = new SavePrompt(LIBRARY);
                        sp.setVisible(true);
                    case 1:
                        frame.dispose(); 
                }
            }});
    }
}
