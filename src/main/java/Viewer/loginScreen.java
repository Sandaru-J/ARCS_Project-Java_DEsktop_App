package Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.lang.*;

public class loginScreen extends JFrame {
    private JPanel lbLogin;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton btnLogin;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JFrame frame;

    public loginScreen() {


        frame = new JFrame("Login Frame");
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(300,300));
        //frame.setResizable(false);

        frame.add(lbLogin);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //setMinimumSize(new Dimension(450,450));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(tfUsername.getText().equals("") || tfPassword.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter all credentials","Try again",JOptionPane.ERROR_MESSAGE);
                    tfPassword.setText("");
                    tfUsername.setText("");

                }else
                {
                    // add a function or sent to relevant class to check login
                }
            }
        });
    }



    public static void main(String[] args) {
        loginScreen form = new loginScreen();
    }

}
