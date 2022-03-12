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
import java.util.ArrayList;
/**
 *
 * @author Michael Tu
 */

public class AutocompleteFrame extends JPanel
{
    //Instance variables
    private JButton addButton;
    private JButton backButton;
    private JLabel directions;
    private static JTable searchResults;
    private static JScrollPane sp;
    private static JTextField titleField;
    private JLabel titleLabel;
    private JButton helpButton;

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
    private void initComponents(Library l)
    {
        directions = new JLabel();
        sp = new JScrollPane();
        searchResults = new JTable();
        titleLabel = new JLabel();
        titleField = new JTextField();
        addButton = new JButton();
        backButton = new JButton();
        helpButton = new JButton();
        JPanel autocompleteFrame = this;

        library = l;
        vbodaLibrary = new VBODALibrary();
        results = new ArrayList<Composition>();

        directions.setText("Search for the composition below from the VBODA database.");

        titleLabel.setText("Title:");

        titleField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }

            // Reset the table of results before repopulating it based on the new search
            private void titleFieldActionPerformed(ActionEvent evt) 
            {
                resetResults();
                Object[][] data = new Object [results.size()][6];
                retrieveData(data);
                populateTable(data);
            }
        });

        addButton.setText("Add");
        addButton.setMnemonic(KeyEvent.VK_ENTER);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }

            // Populates the composition into a new EditFrame
            private void addButtonActionPerformed(ActionEvent evt) 
            {
                int row = searchResults.getSelectedRow();
                Composition c = results.get(row);
                int index = library.getIndex(c);

                JFrame frame = new JFrame("Edit composition");
                EditFrame ef = new EditFrame(frame, library, c, index, true);

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(ef, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });

        backButton.setText("Back");
        backButton.setMnemonic(KeyEvent.VK_BACK_SPACE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }

            // Return to previous frame
            private void backButtonActionPerformed(ActionEvent evt) 
            {
                JComponent comp = (JComponent)evt.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });

        Icon helpIcon = new ImageIcon("helpIcon.png");
        helpButton.setIcon(helpIcon);
        helpButton.setMnemonic(KeyEvent.VK_H);
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }

            // Offers client help
            private void helpButtonActionPerformed(ActionEvent evt)
            {
                String str = "<html>Hit ENTER on an empty search bar to see your entire library.<br>"
                                + "Search a number 1-6 to see all compositions with the corresponding VBODA grade<html>";
                JOptionPane.showMessageDialog(autocompleteFrame, str);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(sp, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(directions)
                    .addGap(85, 85, 85)
                    .addComponent(helpButton)))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(directions)
                    .addComponent(helpButton))
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

    // Resets the results ArrayList
    public static void resetResults()
    {
        results = pullResults();
    }

    // Retrieves the results according to user input from library
    public static ArrayList<Composition> pullResults()
    {
        ArrayList<Composition> arr = new ArrayList<Composition>();
        String input = titleField.getText();
        System.out.println(input);
        
        switch (input)
        {
            case "": // Shows all compositions in the Library
                return vbodaLibrary.getAll();
            case "0": // Shows all compositions with no VBODA grade (i.e. VBODA Grade = 0)
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 0)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "1": // Shows all compositions with VBODA grade of 1
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 1)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "2": // Shows all compositions with VBODA grade of 2
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 2)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "3": // Shows all compositions with VBODA grade of 3
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 3)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "4": // Shows all compositions with VBODA grade of 4
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 4)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "5": // Shows all compositions with VBODA grade of 5
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 5)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            case "6": // Shows all compositions with VBODA grade of 6
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    int vbodaGrade = c.getVbodaGrade();

                    if(vbodaGrade == 6)
                    {
                        arr.add(c);
                    }
                }
                return arr;
            default: // Shows all compositions with the matching title
                for(int i = 0; i < vbodaLibrary.size(); i++)
                {
                    Composition c = vbodaLibrary.getComposition(i);
                    String title = c.getTitle();

                    if(input.equals(title))
                    {
                        arr.add(c);
                    }
                }
                return arr;
        }
    }

    // Populates table with a 2D array representation of the results
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

    // Adds results into a 2D array to input into the table
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
