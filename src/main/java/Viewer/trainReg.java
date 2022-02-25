package Viewer;

import javax.swing.*;

public class trainReg {
    private JButton cancelButton;
    private JButton registerButton;
    private JButton clearButton;
    private JTextField txtTrainId;
    private JTextField txtTName;
    private JTextField txtCapacity;
    private JTextField txtType;
    private JTextField txtSpeed;
    private JPanel mainPanel;
    private JPanel headerPanel;

    public trainReg(){
        JFrame frame = new JFrame("Train Registration");
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        trainReg objtrainreg = new trainReg();
    }
}
