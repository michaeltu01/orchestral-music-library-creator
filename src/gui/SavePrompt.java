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

    public SavePrompt(Library l)
    {
        library = l;

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

        String fullPath = "C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx";
        // String unzippedPath = fullPath.substring(0, fullPath.length() - 5);

        jfc.setCurrentDirectory(new File(fullPath));
        jfc.setSelectedFile(new File("Data.xlsx"));
        jfc.setApproveButtonText("Save");
    
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
        int result = jfc.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            // if(jfc.getSelectedFile().toString().equals("C:/Users/Michael Tu/Desktop/Code/IA/Data.xlsx"))
            // {
            //     JDialog error = new JDialog();
            //     JLabel message = new JLabel();

            //     message.setText("You can't choose this file.");
            //     error.setContentPane(message);
            // }

            File in = new File(fullPath);
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

            //Implement overwriting Data.xlsx

            try {
                Library.write(out);
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
