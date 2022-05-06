package Driver.Viewer_Driver;

//import Admin.Viewer.dashBoard;
import DatabaseConnection.SqlServerConnection;

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
    private JTextField txtDriverPassword;

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

                String DriverUserName = txtDriverUsername.getText();
                String DriverPassword = txtDriverPassword.getText();

                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();

                String qry = "SELECT * FROM ARCSDatabase.dbo.DriverDetails WHERE DriverUserName=? AND DriverPassword=?";
                try {

                    PreparedStatement ps = con.prepareStatement(qry);
                    ps.setString(1,DriverUserName);
                    ps.setString(2,DriverPassword);
                    ResultSet rs = ps.executeQuery();

                    if(rs.next())
                    {
                        new Driver.Viewer_Driver.driverDashboard();
                        frame.dispose();
                        System.out.println("OK");
                    }
                    else
                    {
                        System.out.println("Wrong");
                        txtDriverUsername.setText("");
                        txtDriverPassword.setText("");
                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        new driverLogin();
    }

}
