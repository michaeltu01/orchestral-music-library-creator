/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package src.gui;

import src.backend.Library;
import src.backend.VBODALibrary;
import src.backend.Composition;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author Michael Tu
 */

public class AutocompleteFrame extends JPanel {

    private JButton addButton;
    private JButton backButton;
    private JLabel directions;
    private static JTable searchResults;
    private static JScrollPane sp;
    private static JTextField titleField;
    private JLabel titleLabel;

    private static Library library;
    private static VBODALibrary vbodaLibrary;
    private static ArrayList<Composition> results;
    
    /**
     * Creates new form AutocompleteFrame
     */
    public AutocompleteFrame(Library l) {
        initComponents(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Library l) {

        directions = new JLabel();
        sp = new JScrollPane();
        searchResults = new JTable();
        titleLabel = new JLabel();
        titleField = new JTextField();
        addButton = new JButton();
        backButton = new JButton();

        library = l;
        vbodaLibrary = new VBODALibrary();
        results = new ArrayList<Composition>();

        directions.setText("Search for the composition below from the VBODA database.");

        titleLabel.setText("Title:");

        titleField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }

            private void titleFieldActionPerformed(ActionEvent evt) 
            {
                resetResults();
                Object[][] data = new Object [results.size()][6];
                retrieveData(data);
                populateTable(data);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }

            private void addButtonActionPerformed(ActionEvent evt) 
            {
                int row = searchResults.getSelectedRow();
                Composition c = results.get(row);
                int index = library.getIndex(c);

                EditFrame ef = new EditFrame(library, c, index, true);
                JFrame frame = new JFrame("Edit composition");

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(ef, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }

            private void backButtonActionPerformed(ActionEvent evt) 
            {
                JComponent comp = (JComponent)evt.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(directions)
                    .addComponent(sp, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(directions)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sp, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(backButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static int numSearchResults()
    {
        return results.size();
    }

    public static void resetResults()
    {
        results = pullResults();
    }

    public static ArrayList<Composition> pullResults()
    {
        ArrayList<Composition> arr = new ArrayList<Composition>();
        String input = titleField.getText();
        System.out.println(input);
        
        for(int i = 0; i < vbodaLibrary.size(); i++)
        {
            System.out.println("Running...");
            Composition c = vbodaLibrary.getComposition(i);
            String title = c.getTitle();

            if(input.equals(title))
            {
                arr.add(c);
            }
        }
        return arr;
    }

    public static void populateTable(Object[][] data)
    {
        searchResults.setModel(new javax.swing.table.DefaultTableModel(data,
                new String [] {"Title", "Composer", "Arranger", "Publisher", "VBODA Grade", "Notes"}) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
                };
    
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
    
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
                });
                sp.setViewportView(searchResults);
    }

    public static Object[][] retrieveData(Object[][] data)
    {
        for(int i = 0; i < results.size(); i++)
        {
            ArrayList<String> arr = results.get(i).toStringArrayList();
            for(int j = 0; j < 6; j++)
            {
                data[i][j] = arr.get(j);
            }
        }

        return data;
    }
}
