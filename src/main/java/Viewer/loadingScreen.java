package Viewer;

import com.sun.javaws.ui.SplashScreen;

import javax.swing.*;
import java.awt.*;

public class loadingScreen{
    private JPanel panel1;
    private JPanel BackgroundPanel;
    private JProgressBar progressBar1;
    private JLabel lblARCS;
    private JLabel lblImage;
    private JLabel lblLoading;
    private JLabel lblLOadingValue;



    public loadingScreen()
    {
        JFrame frame = new JFrame("Loading");
        frame.setUndecorated(true);
        frame.add(BackgroundPanel);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loadingScreen ls = new loadingScreen();


        try{

            for (int i = 0; i < 100; i++) {

                Thread.sleep(100);
                ls.lblLoading.setText(i+"%");

                if(i==0)
                {
                    ls.lblLoading.setText("Turning on Modules...");
                }
                if(i==20)
                {
                    ls.lblLoading.setText("Loading Modules...");
                }
                if(i==50)
                {
                    ls.lblLoading.setText("Connecting to Database...");
                }
                if(i==70)
                {
                    ls.lblLoading.setText("Connected Successfully...");
                }
                if(i==85)
                {
                    ls.lblLoading.setText("Launching Application...");
                }

            }

        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }

    }


    private void createUIComponents() {

        lblImage = new JLabel(new ImageIcon("Images/train.png"));



    }

    public static void main(String[] args) {
        new loadingScreen();
    }
}
