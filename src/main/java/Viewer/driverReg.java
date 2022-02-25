package Viewer;

import javax.swing.*;

public class driverReg extends JFrame {
    private JLabel lblDriverReg;
    private JButton btnCancel;
    private JButton btnRegister;
    private JButton btnClear;
    private JTextField txtDriverId;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtNic;
    private JTextField txtRoute;
    private JTextField txtContact;
    private JTextField txtEmail;
    private JPanel mainPanel;
    private JPanel titlePnael;
    private JFrame frame;

    public driverReg(){

        JFrame frame = new JFrame("Driver Registration");
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        driverReg form = new driverReg();
    }
}
