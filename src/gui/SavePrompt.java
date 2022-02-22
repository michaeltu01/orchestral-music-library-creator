package src.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

import src.backend.Library;
import src.backend.Composition;

public class SavePrompt extends JPanel { // https://stackoverflow.com/a/23143716 

    private static JFrame saveFrame;
    private static JPanel SPanel;
    private static JFileChooser jfc;
    private static Library library;

    private static File f;

    public SavePrompt(Library l)
    {
        library = l;
        try {
            f = new File(library.getFilePath());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            initComponents();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() throws IOException, FileNotFoundException
    {
        saveFrame = new JFrame();
        // SPanel = new JPanel();
        jfc = new JFileChooser();

        jfc.setCurrentDirectory(f);
        jfc.setSelectedFile(new File("Database.xlsx"));
        jfc.setApproveButtonText("Save");
    
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
        int result = jfc.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            // System.out.println(jfc.getSelectedFile().toString());
            // switch(jfc.getSelectedFile().toString())
            // {
            //     case: "Database.xlsx"
            //     {
            //         JOptionPane.showMessageDialog(jfc, "You can't choose this file.");
            //     }
            // }
            File out = new File(jfc.getSelectedFile().toString());
            // System.out.println(out.getAbsolutePath());
            // int BUF_SIZE = (int) in.length();
    
            // FileInputStream fiss = new FileInputStream(in);
            // FileOutputStream foss = new FileOutputStream(out);
            // try{
            //     byte[] buf = new byte[BUF_SIZE];
            //     int i = 0;
            //     while((i = fiss.read(buf)) != -1){
            //         foss.write(buf, 0, i);
            //     }
            // }
            // catch(Exception e){
            //     throw e;
            // }
            // finally{
            //     if(fiss != null) fiss.close();
            //     if(foss != null) foss.close();
            // }
            // saveFrame.setVisible(false);

            //Implement overwriting Database.xlsx
            try {
                if(f.equals(out))
                {
                    Library.write(out);
                }
                else
                {
                    Library.write(f);
                    Library.write(out);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            saveFrame.setVisible(false);
        }
    
        // SPanel.setLayout(new FlowLayout());
        // SPanel.add(jfc);
    
        // saveFrame.setLayout(new FlowLayout());
        // saveFrame.add(SPanel);
        // saveFrame.pack();
        // saveFrame.setTitle("Save your Doc");
        // saveFrame.setLocationRelativeTo(null);
        // saveFrame.setVisible(true);
    }
}
