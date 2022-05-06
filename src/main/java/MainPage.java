
//import Admin.Viewer.Login;
import Driver.Viewer_Driver.driverDashboard;
import Driver.Viewer_Driver.driverLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;

public class MainPage {
    private JButton adminButton;
    private JButton driverButton;
    private JPanel panelMainPage;

    public MainPage()
    {

        JFrame frame = new JFrame();
        //frame.setUndecorated(true);
        frame.add(panelMainPage);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,400);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                new Admin.Viewer.Login();
//                frame.dispose();

            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                new Driver.Viewer_Driver.driverLogin();
//                frame.dispose();

            }
        });
    }

    public static void main(String[] args) {
        new MainPage();
    }

}
