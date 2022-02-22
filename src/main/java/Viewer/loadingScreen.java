package Viewer;

import javax.swing.*;

public class loadingScreen extends JFrame {
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JRadioButton radioButton1;
    private JPasswordField passwordField1;
    private JTable table1;
    private JLabel mainPanel;

    public loadingScreen(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame =new loadingScreen("Loading Screen");
        frame.setVisible(true);
    }
}
