package Viewer;

import javax.swing.*;

public class dashBoard {
    private JPanel dashPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane4;
    private JTextField txtJourneyName;
    private JTextField txtStartingTime;
    private JTextField txtStartingStation;
    private JTextField txtTrainID;
    private JTextField txtBlockID;
    private JCheckBox cbMonday;
    private JCheckBox cbTuesday;
    private JCheckBox cbWednesday;
    private JCheckBox cbThursday;
    private JCheckBox cbFriday;
    private JCheckBox cbSaturday;
    private JCheckBox cbSunday;
    private JTextField txtEndTime;
    private JTextField txtDestination;
    private JComboBox cmbJourneyType;
    private JTextField txtNoOfBlocks;
    private JButton btnCancel;
    private JButton btnCreate;
    private JButton btnClear;
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
    private JTextField txtTrain;
    private JTextField txtTrainName;
    private JTextField txtCapacity;
    private JComboBox cmbType;
    private JTextField txtSpeed;
    private JButton btnCancle;
    private JButton btnRegister;
    private JButton cancelButton2;
    private JButton registerButton1;
    private JButton cancelButton3;
    private JButton registerButton2;
    private JLabel lblJourneyID;
    private JLabel lblDuration;
    private JLabel lblDistance;
    private JLabel lblDriverID;
    private JPanel lblEngineID;


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
