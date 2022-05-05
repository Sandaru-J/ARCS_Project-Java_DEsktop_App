package Viewer;

import DatabaseConnection.SqlServerConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import Viewer.dashBoard;

public class Login extends JFrame{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPanel panelLogin;
    private JButton loginButton;
    private JButton clearButton;

    public Login()
    {

        JFrame frame = new JFrame("Login");
        //frame.setUndecorated(true);
        frame.add(panelLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(950,400);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                new dashBoard().setVisible(true);
//                System.out.println("OK");

                String AdminUserName = txtUsername.getText();
                String AdminPassword = txtPassword.getText();

                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();

                //String qry = "SELECT * FROM ARCSDatabase.dbo.AdminDetails WHERE AdminUserName=? AND AdminPassword=?";
                try {
                    CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.CheckAdminUserName(?)}");
                    cs.setString(1,AdminUserName);
                    //ps.setString(2,AdminPassword);
                    ResultSet rs = cs.executeQuery();

                    if(!rs.next())
                    {
                        System.out.println("you are not a registerd user");
                        txtUsername.setText("");
                        txtPassword.setText("");

                        return;
                    }else{
                        System.out.println("asfda");
                    }
                    CallableStatement cs2 = con.prepareCall("{call ARCSDatabase.dbo.CheckAdminConfirmation(?,?)}");
                    cs2.setString(1,AdminUserName);
                    cs2.setString(2,AdminPassword);
                    ResultSet rs1 = cs2.executeQuery();

                    if(rs1.next())
                    {

                        new dashBoard();
                        return;
                    }else{

                        System.out.println("Incorrect password");
                        txtUsername.setText("");
                        txtPassword.setText("");
                    }
                    System.out.println(rs1.next());

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
