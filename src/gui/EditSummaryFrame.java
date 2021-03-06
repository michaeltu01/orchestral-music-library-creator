/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package src.gui;

import src.backend.Composition;
import src.backend.Library;

import java.awt.Window;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Michael Tu
 */
public class EditSummaryFrame extends JPanel
{
    // Instance variables
    public JButton backButton;
    private JTextPane metadata;
    private JLabel title;
    private JScrollPane sp;

    /**
     * Creates new form EditConfirmationFrame
     */
    public EditSummaryFrame(Composition c, Library l) {
        initComponents(c, l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Composition c, Library l)
    {
        title = new JLabel();
        metadata = new JTextPane();
        backButton = new JButton();
        sp = new JScrollPane(metadata, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("You added the following composition:");

        metadata.setEditable(false);
        metadata.setContentType("text/html");
        metadata.setText("<html>Title: " + c.getTitle()
                            + "<br>Composer: " + c.getComposer()
                            + "<br>Arranger: " + c.getArranger()
                            + "<br>Publisher: " + c.getPublisher()
                            + "<br>VBODA Grade: " + c.getVbodaGrade()
                            + "<br>Notes: " + c.getNotes() + "</html>");

        backButton.setText("OK");
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

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(sp, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(177, 177, 177))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
}
