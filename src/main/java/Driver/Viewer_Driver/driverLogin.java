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
    private JTextField txtDriverPassword1;

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

                if (txtDriverUsername.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelDriverLogin, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else if (txtDriverUsername.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelDriverLogin, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else {
                    String DriverUserName = txtDriverUsername.getText();
                    String DriverPassword = txtDriverUsername.getText();

                    DriverController driverController = new DriverController();
                    boolean i = driverController.driverLogin(DriverUserName, DriverPassword);

                    if (!i) {
                        new driverAssignedJourneys();
                        frame.dispose();
                        System.out.println("OK");

                    } else {
                        System.out.println("Wrong");
                        txtDriverUsername.setText("");
                        txtDriverPassword1.setText("");
                    }


                }
            }
        });
    }

    public static void main(String[] args) {
        new driverLogin();
    }

}
