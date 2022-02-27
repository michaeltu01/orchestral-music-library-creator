package src.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import src.backend.Library;

public class SavePrompt extends JPanel { // https://stackoverflow.com/a/23143716 

    private static JFrame saveFrame;
    private static JFileChooser jfc;
    private static Library library;

    private static File database;

    public SavePrompt(Library l)
    {
        library = l;
        try {
            database = new File(library.getFilePath());
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
        jfc = new JFileChooser();

        jfc.setCurrentDirectory(database);
        jfc.setSelectedFile(database.getAbsoluteFile());    
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setApproveButtonText("Save");
    
        int result = jfc.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
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
            try 
            {
                if(database.equals(out))
                {
                    Library.write(out);
                }
                else
                {
                    Library.write(database);
                    Library.write(out);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            saveFrame.setVisible(false);
        }
    }
}
