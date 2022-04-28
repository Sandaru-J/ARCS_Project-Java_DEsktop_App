package Viewer;

import javax.swing.*;
import java.awt.*;

public class Signup extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton clearButton;
    private JPanel panel1;

    public Signup() {

        JFrame frame = new JFrame("Signup");
        frame.setUndecorated(true);
        frame.add(panel1);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        loadingScreen ls = new loadingScreen();

    }

    public static void main(String[] args) {
        Signup signup = new Signup();
    }



}
