package Admin.Viewer;

import javax.swing.*;

public class loadingScreen{
    private JPanel panel1;
    private JPanel BackgroundPanel;
    private JProgressBar progressBar1;
    private JLabel lblLoading;
    private JLabel lblLoadingValue;
    private JLabel lblARCS;


    public loadingScreen()
    {

        JFrame frame = new JFrame("Loading");
        frame.setUndecorated(true);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        try{

            for (int i = 0; i <= 100; i++) {

                Thread.sleep(100);
                lblLoadingValue.setText(i+"%");
                progressBar1.setValue(i);

                if(i==0)
                {
                    lblLoading.setText("Turning on Modules...");
                }
                if(i==20)
                {
                    lblLoading.setText("Loading Modules...");
                }
                if(i==45)
                {
                    lblLoading.setText("Connecting to Database...");
                }
                if(i==70)
                {
                    lblLoading.setText("Connected Successfully...");
                }
                if(i==85)
                {
                    lblLoading.setText("Launching Application...");
                }


            }

        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        new Login();
        frame.dispose();

    }



    public static void main(String[] args) {
        new loadingScreen();
    }


}
