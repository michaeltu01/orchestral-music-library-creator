/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui;

import src.backend.Composition;
import src.backend.XLSXMusicLibrary;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Michael Tu
 */
public class EditFrame extends JPanel 
{
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addButton;
    private JTextField arrangerField;
    private JButton backButton;
    private JTextField composerField;
    private JLabel directions;
    private JLabel titleLabel;
    private JLabel composerLabel;
    private JLabel arrangerLabel;
    private JLabel publisherLabel;
    private JLabel vbodaGradeLabel;
    private JLabel notesLabel;
    private JTextField notesField;
    private JTextField publisherField;
    private JTextField titleField;
    private JTextField vbodaGradeField;

    private static XLSXMusicLibrary library; //Create a general object
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form EditFrame
     */
    
    
    public EditFrame() {
        initComponents();
        library = new XLSXMusicLibrary();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directions = new JLabel();
        titleLabel = new JLabel();
        titleField = new JTextField();
        composerLabel = new JLabel();
        composerField = new JTextField();
        arrangerLabel = new JLabel();
        arrangerField = new JTextField();
        publisherLabel = new JLabel();
        publisherField = new JTextField();
        vbodaGradeField = new JTextField();
        vbodaGradeLabel = new JLabel();
        notesField = new JTextField();
        notesLabel = new JLabel();
        addButton = new JButton();
        backButton = new JButton();

        directions.setHorizontalAlignment(SwingConstants.CENTER);
        directions.setText("Enter information below to add a composition.");

        titleLabel.setText("Title:");

        titleField.setText("");
        titleField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        composerLabel.setText("Composer:");

        composerField.setText("");
        composerField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                composerFieldActionPerformed(evt);
            }
        });

        arrangerLabel.setText("Arranger: ");

        arrangerField.setText("");
        arrangerField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                arrangerFieldActionPerformed(evt);
            }
        });

        publisherLabel.setText("Publisher:");

        publisherField.setText("");
        publisherField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                publisherFieldActionPerformed(evt);
            }
        });

        vbodaGradeField.setText("");
        vbodaGradeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                vbodaGradeFieldActionPerformed(evt);
            }
        });

        vbodaGradeLabel.setText("VBODA Grade: ");

        notesField.setText("");
        notesField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        notesLabel.setText("Notes:");

        addButton.setText("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    addButtonActionPerformed(evt);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        backButton.setText("Back");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(directions))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(vbodaGradeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vbodaGradeField, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(notesLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(notesField, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(composerLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(composerField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(titleLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(titleField, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(arrangerLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(arrangerField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(publisherLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(publisherField, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(directions)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(composerLabel)
                    .addComponent(composerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(arrangerLabel)
                    .addComponent(arrangerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(publisherLabel)
                    .addComponent(publisherField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(vbodaGradeLabel)
                    .addComponent(vbodaGradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(notesLabel)
                    .addComponent(notesField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(backButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void composerFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_composerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composerFieldActionPerformed

    private void arrangerFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_arrangerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrangerFieldActionPerformed

    private void publisherFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_publisherFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publisherFieldActionPerformed

    private void vbodaGradeFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_vbodaGradeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vbodaGradeFieldActionPerformed

    private void notesFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_notesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notesFieldActionPerformed

    private void addButtonActionPerformed(ActionEvent evt) throws Exception
    {
        Composition c = new Composition(titleField.getText(),
                                            composerField.getText(),
                                            arrangerField.getText(),
                                            publisherField.getText(),
                                            Integer.parseInt(vbodaGradeField.getText()),
                                            notesField.getText());
        library.add(c);
        XLSXMusicLibrary.write();

        EditSummaryFrame ecFrame = new EditSummaryFrame(c, library);

        //1. Create the frame.
        JFrame frame = new JFrame("EditConfirmationFrame");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create your panel and put it in the frame.
        frame.getContentPane().add(ecFrame, BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //1. Create the frame.
        JFrame frame = new JFrame("EditFrame");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create your panel and put it in the frame.
        frame.getContentPane().add(new EditFrame(), BorderLayout.CENTER);

        //4. Size the frame.
        frame.pack();

        //5. Show it.
        frame.setVisible(true);
    }
}
