package Viewer;

import javax.swing.*;

public class trainBlocksReg {
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JButton registerButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField lTextField;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField6;

    public trainBlocksReg(){
        JFrame frame = new JFrame("Train Blocks Registration");
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        trainBlocksReg objTrainBlockReg = new trainBlocksReg();
    }
}
