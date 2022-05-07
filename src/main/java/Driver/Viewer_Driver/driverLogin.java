package Driver.Viewer_Driver;

//import Admin.Viewer.dashBoard;
import Driver.Controller_Driver.DriverController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class driverLogin {
    private JTextField txtDriverUsername;
    private JButton driverLoginButton;
    private JButton driverClearButton;
    private JPanel panelDriverLogin;
    private JTextField txtDriverPassword;

    String DriverUserName;
    public driverLogin()
    {
        JFrame frame = new JFrame("Login");
        //frame.setUndecorated(true);
        frame.add(panelDriverLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(950,400);


        driverLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DriverUserName = txtDriverUsername.getText();
                String DriverPassword = txtDriverPassword.getText();

                DriverController driverController = new DriverController();
                boolean i = driverController.driverLogin(DriverUserName, DriverPassword);

                if(!i)
                {
                    new driverDashboard();
                    frame.dispose();
                    System.out.println("OK");

                }
                else
                {
                    System.out.println("Wrong");
                    txtDriverUsername.setText("");
                    txtDriverPassword.setText("");
                }


            }
        });
    }

    public static void main(String[] args) {
        new driverLogin();
    }

}
