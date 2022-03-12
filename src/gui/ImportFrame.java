package src.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import src.backend.Library;

public class ImportFrame extends JFileChooser 
{
    // Instance variables
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
            // Check if selected file is the database
            if(jfc.getSelectedFile().getAbsolutePath().equals(database.getAbsolutePath()))
            {
                System.out.println("You chose the database.");
                JOptionPane.showMessageDialog(null, "You can't choose the internal database.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                File in = new File(jfc.getSelectedFile().getAbsolutePath());

                //Read from Database.xlsx
                try {
                    Library.read(in);
                    library.sortByTitle();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Close out of the JFileChooser
        else if(result == JFileChooser.CANCEL_OPTION){
            jfc.setVisible(false);
        }
    }
}
