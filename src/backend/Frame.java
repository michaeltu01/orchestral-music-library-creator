import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame 
{
    public static JFrame createHomeFrame()
    {
        JFrame home = new JFrame("Music Library Creator");
        JLabel welcome = new JLabel("Welcome to the Music Library Creator!", JLabel.CENTER);
        JButton start = new JButton("Start");

        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.getContentPane().add(welcome);
        home.getContentPane().add(start);
        home.setSize(800, 800); //pack()
        home.setLocationRelativeTo(null);
        home.setVisible(true);

        return home;
    }

    public static void mainFrame() //Enter all the metadata
    {

    }

    public static void main(String[] args)
    {
        createHomeFrame();
    }


}