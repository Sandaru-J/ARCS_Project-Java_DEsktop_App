package Driver.Viewer_Driver;

//import Admin.Viewer.dashBoard;
import DatabaseConnection.SqlServerConnection;
import Driver.Controller_Driver.DriverController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

                    SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                    Connection con = objSqlServerConnection.createConnectionSqlServer();

                    String qry = "SELECT * FROM ARCSDatabase.dbo.DriverDetails WHERE DriverUserName=? AND DriverPassword=?";
                    try {

                        PreparedStatement ps = con.prepareStatement(qry);
                        ps.setString(1, DriverUserName);
                        ps.setString(2, DriverPassword);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            new driverAssignedJourneys();
                            frame.dispose();
                            System.out.println("OK");

                        } else {

                            JOptionPane.showMessageDialog(panelDriverLogin, "Invalid Credentials", "Try Again!", JOptionPane.ERROR_MESSAGE);
                            System.out.println("Wrong");
                            txtDriverUsername.setText("");
                            txtDriverPassword1.setText("");
                        }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        }

    public static void main(String[] args) {
        new driverLogin();
    }

}

