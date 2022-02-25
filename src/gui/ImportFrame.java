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

public class ImportFrame extends JFileChooser { // https://stackoverflow.com/a/23143716 

    private static JFileChooser jfc;
    private static Library library;
    private static File database;

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
        UIManager.put("FileChooser.saveButtonText", "Import");
        jfc = new JFileChooser();
        database = new File(library.getFilePath());

        jfc.setCurrentDirectory(database);
        jfc.setSelectedFile(database.getAbsoluteFile());    
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = jfc.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            if(jfc.getSelectedFile().getAbsolutePath().equals(database.getAbsolutePath()))
            {
                System.out.println("You chose the database.");
                JOptionPane.showMessageDialog(null, "You can't choose the internal database.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
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
                    library.sortByTitle();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            jfc.setVisible(false);
        }
    }
}
