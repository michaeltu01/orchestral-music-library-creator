/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;

import src.backend.Composition;
import src.backend.Library;
/**
 *
 * @author Michael Tu
 */
public class ViewFrame extends JPanel {

    private JLabel directions;
    private JButton backButton;
    private JButton deleteButton;
    private JButton clearLibraryButton;
    private JButton editButton;
    private static JTable searchResults;
    private static JScrollPane sp;
    private static JTextField titleField;
    private JLabel titleLabel;

    private static Library library;
    private static ArrayList<Composition> results;
    
    /**
     * Creates new form ViewFrame
     */
    public ViewFrame(Library l) {
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
        titleLabel = new JLabel();
        titleField = new JTextField();
        editButton = new JButton();
        deleteButton = new JButton();
        backButton = new JButton();
        sp = new JScrollPane();
        searchResults = new JTable();
        clearLibraryButton = new JButton();
        
        library = l;
        results = new ArrayList<Composition>();

        directions.setHorizontalAlignment(SwingConstants.CENTER);
        directions.setText("Search for the composition below. Number of results: ");

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
                directions.setHorizontalAlignment(SwingConstants.CENTER);
                directions.setText("Search for the composition below. Number of results: " + numSearchResults()); 
            }
        });

        clearLibraryButton.setText("Clear Library");
        clearLibraryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt)
            {
                clearLibraryButtonActionPerformed(evt);
            }

            private void clearLibraryButtonActionPerformed(ActionEvent evt)
            {
                library.clear();
                library.toString();

                JDialog dialog = new JDialog();
                JLabel confMessage = new JLabel("Library has been cleared. Confirm your save upon closing the application.");

                confMessage.setHorizontalAlignment(JLabel.CENTER);
                dialog.add(confMessage);
                dialog.setSize(500, 100);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }

            private void editButtonActionPerformed(ActionEvent evt) 
            {
                int row = searchResults.getSelectedRow();
                Composition c = results.get(row);
                int index = library.getIndex(c);

                EditFrame ef = new EditFrame(library, c, index, false);
                JFrame frame = new JFrame("Edit composition");

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(ef, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }

            private void deleteButtonActionPerformed(ActionEvent evt)
            {
                int row = searchResults.getSelectedRow();
                Composition c = results.get(row);
                results.remove(c);
                library.remove(c);
        
                Object[][] data = new Object[results.size()][6];
                populateTable(retrieveData(data));
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
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(sp, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clearLibraryButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(directions)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(23, 23, 23)
                .addComponent(sp, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(backButton)
                    .addComponent(clearLibraryButton))
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
        
        if(input.equals("")) // Shows all compositions in the Library
        {
            return library.getAll();
        }
        else if(input.equals("0")) // Shows all compositions with no VBODA grade (i.e. VBODA Grade = 0)
        {
            for(int i = 0; i < library.size(); i++)
            {
                Composition c = library.getComposition(i);
                int vbodaGrade = c.getVbodaGrade();

                if(vbodaGrade == 0)
                {
                    arr.add(c);
                }
            }
        }
        else // Shows all compositions with the matching title
        {
            for(int i = 0; i < library.size(); i++)
            {
                Composition c = library.getComposition(i);
                String title = c.getTitle();

                if(input.equals(title))
                {
                    arr.add(c);
                }
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

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("ViewFrame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ViewFrame(library), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
