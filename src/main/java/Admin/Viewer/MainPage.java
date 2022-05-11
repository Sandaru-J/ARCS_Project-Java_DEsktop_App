package Admin.Viewer;

import Driver.Viewer_Driver.driverLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JButton adminButton;
    private JButton driverButton;
    private JPanel panelMainPage;
    private JLabel lblHeading;

    public MainPage()
    {

        JFrame frame = new JFrame();
        //frame.setUndecorated(true);
        frame.add(panelMainPage);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,400);

        lblHeading.setText("<html>AUTOMATED RAILWAY<br/>&nbsp;&nbsp;&nbsp;CONTROL SYSTEM</html>");

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Login();
                frame.dispose();

            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new driverLogin();
                frame.dispose();

            }
        });
    }

    public static void main(String[] args) {
        new MainPage();
    }

}
