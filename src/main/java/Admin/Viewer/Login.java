package Admin.Viewer;

import DatabaseConnection.SqlServerConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPanel panelLogin;
    private JButton loginButton;
    private JButton clearButton;
    private JLabel lbkABC;

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

                if (txtUsername.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelLogin, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else if (txtPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelLogin, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                } else {

                    String AdminUserName = txtUsername.getText();
                    String AdminPassword = txtPassword.getText();

                    SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                    Connection con = objSqlServerConnection.createConnectionSqlServer();

                    String qry = "SELECT * FROM ARCSDatabase.dbo.AdminDetails WHERE AdminUserName=? AND AdminPassword=?";
                    try {

                        PreparedStatement ps = con.prepareStatement(qry);
                        ps.setString(1, AdminUserName);
                        ps.setString(2, AdminPassword);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            new dashBoard();
                            frame.dispose();
                            System.out.println("OK");
                        } else {
                            JOptionPane.showMessageDialog(panelLogin, "Invalid Credentials", "Try Again!", JOptionPane.ERROR_MESSAGE);
                            System.out.println("Wrong");
                            txtUsername.setText("");
                            txtPassword.setText("");
                        }

                    boolean i = rs.next();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
