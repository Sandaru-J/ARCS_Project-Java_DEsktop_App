package Viewer;

import javax.swing.*;
import java.awt.*;

public class loginScreen extends JFrame {
    private JPanel lbLogin;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton btnLogin;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JFrame frame;

    public loginScreen(){


            frame = new JFrame("Login Frame");
            //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            //frame.setPreferredSize(new Dimension(300,300));
            //frame.setResizable(false);

            frame.add(lbLogin);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            //setMinimumSize(new Dimension(450,450));


    }

    public static void main(String[] args) {
        loginScreen form = new loginScreen();
    }

}
