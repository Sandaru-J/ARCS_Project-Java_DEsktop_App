package Viewer;

import DatabaseConnection.SqlServerConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Login {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPanel panelLogin;
    private JButton loginButton;
    private JButton clearButton;

    public Login()
    {

        JFrame frame = new JFrame("Login");
        frame.setUndecorated(true);
        frame.add(panelLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String AdminUserName = txtUsername.getText();
                String AdminPassword = txtPassword.getText();

                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();

                try {

                    PreparedStatement ps = con.prepareStatement("SELECT * FROM ARCSDatabase.dbo.AdminDetails WHERE AdminUserName=? AND AdminPassword=?");
                    ps.setString(1,AdminUserName);
                    ps.setString(2,AdminPassword);

                    ps.execute();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtUsername.setText("");
                txtPassword.setText("");

            }
        });
    }

    public static void main(String[] args) {

        new Login();
    }

}
