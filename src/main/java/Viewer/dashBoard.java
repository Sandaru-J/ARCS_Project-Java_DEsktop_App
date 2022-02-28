package Viewer;

import javax.swing.*;

public class dashBoard {
    private JPanel dashPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField8;
    private JTextField textField9;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JTextField textField7;
    private JTextField textField10;
    private JTextField textField11;
    private JComboBox comboBox1;
    private JTextField textField12;
    private JTextField textField13;
    private JButton cancelButton;
    private JButton createButton;
    private JButton clearButton;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField23;
    private JTextField textField24;
    private JTextField textField25;
    private JComboBox comboBox2;
    private JTextField textField22;
    private JTextField textField26;
    private JTextField textField27;
    private JTextField textField28;
    private JTextField textField29;
    private JComboBox comboBox3;


    public dashBoard(){
        JFrame frame = new JFrame("Dashboard");
        frame.add(dashPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,600);

    }

    public static void main(String[] args) {
        dashBoard panel = new dashBoard();

    }


}
