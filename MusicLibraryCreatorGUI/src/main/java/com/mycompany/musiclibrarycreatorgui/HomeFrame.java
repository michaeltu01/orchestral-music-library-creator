/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.musiclibrarycreatorgui;

import javax.swing.*;

/**
 *
 * @author Michael Tu
 */
public class HomeFrame extends javax.swing.JPanel {

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
        initComponents();
        Icon helpIcon = new ImageIcon("helpIcon.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMessage = new javax.swing.JLabel();
        directions = new javax.swing.JLabel();
        importButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        autocompleteButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        welcomeMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeMessage.setText("Welcome Mr. Kelly to the Orchestra Music Library Creator!");

        directions.setText("Select a button below to get started.");

        importButton.setText("Import library");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add music");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View library");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        autocompleteButton.setText("Input using title");
        autocompleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autocompleteButtonActionPerformed(evt);
            }
        });

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/musiclibrarycreatorgui/helpIcon.png"))); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(autocompleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(viewButton)
                        .addContainerGap(138, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(welcomeMessage)
                            .addComponent(directions))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(welcomeMessage)
                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(directions)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(addButton)
                    .addComponent(viewButton)
                    .addComponent(autocompleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewButtonActionPerformed

    private void autocompleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autocompleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autocompleteButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton autocompleteButton;
    private javax.swing.JLabel directions;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton importButton;
    private javax.swing.JButton viewButton;
    private javax.swing.JLabel welcomeMessage;
    // End of variables declaration//GEN-END:variables
}
