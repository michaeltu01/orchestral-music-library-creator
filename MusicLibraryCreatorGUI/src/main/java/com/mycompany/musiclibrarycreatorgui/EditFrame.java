/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.musiclibrarycreatorgui;

import src.backend;

import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Michael Tu
 */
public class EditFrame extends JPanel 
{
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField arrangerField;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField composerField;
    private javax.swing.JLabel directions;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField notesField;
    private javax.swing.JTextField publisherField;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField vbodaGradeField;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form EditFrame
     */
    
    
    public EditFrame() {
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

        jLabel2 = new javax.swing.JLabel();
        directions = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        composerField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        arrangerField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        publisherField = new javax.swing.JTextField();
        vbodaGradeField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        notesField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        directions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        directions.setText("Enter the information below to add a composition.");

        jLabel3.setText("Title:");

        titleField.setText("jTextField1");
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Composer:");

        composerField.setText("jTextField1");
        composerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composerFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Arranger: ");

        arrangerField.setText("jTextField1");
        arrangerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrangerFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Publisher:");

        publisherField.setText("jTextField1");
        publisherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherFieldActionPerformed(evt);
            }
        });

        vbodaGradeField.setText("jTextField1");
        vbodaGradeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vbodaGradeFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("VBODA Grade: ");

        notesField.setText("jTextField1");
        notesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Notes:");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(directions))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vbodaGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(composerField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(arrangerField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(directions)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(composerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(arrangerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vbodaGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        Composition c = new Composition(titleField.getText(),
                                            composerField.getText(),
                                            arrangerField.getText(),
                                            publisherField.getText(),
                                            Integer.parseInt(vbodaGradeField.getText()),
                                            notesField.getText());
        Library.append(c);
    }//GEN-LAST:event_addButtonActionPerformed

    public static void main(String[] args)
    {
        EditFrame frame = new EditFrame();

        frame.setVisible(true);
    }
}
