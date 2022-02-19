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

public class ImportFrame extends JPanel { // https://stackoverflow.com/a/23143716 

    private static JFrame importFrame;
    private static JPanel IPanel;
    private static JFileChooser jfc;
    private static Library library;

    public ImportFrame(Library l)
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
        importFrame = new JFrame();
        // IPanel = new JPanel();
        jfc = new JFileChooser();

        String fullPath = "C:/Users/Michael Tu/Desktop/Code/IA/Database.xlsx";
        // String unzippedPath = fullPath.substring(0, fullPath.length() - 5);

        jfc.setCurrentDirectory(new File(fullPath));
        jfc.setSelectedFile(new File("Database.xlsx"));
        jfc.setApproveButtonText("Import");
    
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    
        int result = jfc.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            // if(jfc.getSelectedFile().toString().equals("C:/Users/Michael Tu/Desktop/Code/IA/Database.xlsx"))
            // {
            //     JDialog error = new JDialog();
            //     JLabel message = new JLabel();

            //     message.setText("You can't choose this file.");
            //     error.setContentPane(message);
            // }

            File in = new File(jfc.getSelectedFile().getAbsolutePath());
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
            // importFrame.setVisible(false);

            //Implement read from Database.xlsx

            try {
                Library.read(in);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        else if(result == JFileChooser.CANCEL_OPTION){
            importFrame.setVisible(false);
        }
    
        // IPanel.setLayout(new FlowLayout());
        // IPanel.add(jfc);
    
        // importFrame.setLayout(new FlowLayout());
        // importFrame.add(IPanel);
        // importFrame.pack();
        // importFrame.setTitle("Save your Doc");
        // importFrame.setLocationRelativeTo(null);
        // importFrame.setVisible(true);
    }
}
