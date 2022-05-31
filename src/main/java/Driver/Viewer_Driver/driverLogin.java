package Driver.Viewer_Driver;

//import Admin.Viewer.dashBoard;
import DatabaseConnection.SqlServerConnection;
import Driver.Controller_Driver.DriverController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    JOptionPane.showMessageDialog(panelDriverLogin, "Username Missing!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else if (txtDriverPassword1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelDriverLogin, "Password Missing!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else {
                    String DriverUserName = txtDriverUsername.getText();
                    String DriverPassword = txtDriverPassword1.getText();

                    DriverController driverController = new DriverController();
                    boolean i = driverController.driverLogin(DriverUserName, DriverPassword);

                    if (!i) {
                        new driverAssignedJourneys();
                        frame.dispose();
                        System.out.println("OK");
                        try {
                            logAlert();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        System.out.println("Wrong");
                        txtDriverUsername.setText("");
                        txtDriverPassword1.setText("");
                    }


                }
            }
        });
    }
    public void logAlert() throws SQLException, SQLException {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        String qry = "INSERT INTO [ARCSDatabase].[dbo].[log] VALUES (?,?)";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        String alert= "Driver "+txtDriverUsername.getText()+" has logged into system";
        String time = formatter.format(date);
        System.out.println(formatter.format(date)+" Driver "+txtDriverUsername.getText()+" has logged into system");
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setString(1, time);
        ps.setString(2, alert);
        ps.execute();


    }

    public static void main(String[] args) {
        new driverLogin();
    }

}
