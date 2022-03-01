package Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTextField txtFullName;
    private JTextField txtAge;
    private JTextField txtNIC;
    private JTextField txtAssignedRoutes;
    private JTextField txtContactNumber;
    private JTextField txtEmail;
    private JTextField txtBlockType;
    private JTextField txtLength;
    private JTextField txtQuantity;
    private JComboBox cbmBlockName;
    private JTextField txtWeight;
    private JTextField txtCap;
    private JTextField txtTrain;
    private JTextField txtTrainName;
    private JTextField txtCapacity;
    private JComboBox cmbType;
    private JTextField txtSpeed;
    private JButton btnCancle;
    private JButton btnRegister;
    private JButton btnDriverCancel;
    private JButton btnDriverRegister;
    private JButton btnBlockCancel;
    private JButton btnBlockRegister;
    private JLabel lblJourneyID;
    private JLabel lblDuration;
    private JLabel lblDistance;
    private JLabel lblDriverID;
    private JPanel lblEngineID;
    private JTextField txtBlock;
    private JTextField txtDriver;


    public dashBoard(){
        JFrame frame = new JFrame("Dashboard");
        frame.add(dashPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,600);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtJourneyName.setText("");
                lblEngineID.setToolTipText("");
                txtStartingTime.setText("");
                txtEndTime.setText("");
                txtStartingStation.setText("");
                txtDestination.setText("");
                lblDuration.setText("");
                lblDistance.setText("");
                txtTrainID.setText("");
                cmbJourneyType.setToolTipText("");
                txtBlockID.setText("");
                txtNoOfBlocks.setText("");

            }
        });

        btnDriverCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDriver.setText("");
                txtFullName.setText("");
                txtAge.setText("");
                txtNIC.setText("");
                txtAssignedRoutes.setText("");
                txtContactNumber.setText("");
                txtEmail.setText("");
            }
        });
        btnCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTrain.setText("");
                txtTrainName.setText("");
                txtCapacity.setText("");
                cmbType.setToolTipText("");
                txtSpeed.setText("");
            }
        });
        btnBlockCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBlock.setText("");
                cbmBlockName.setToolTipText("");
                txtBlockType.setText("");
                txtLength.setText("");
                txtQuantity.setText("");
                txtWeight.setText("");
                txtCap.setText("");
            }
        });
    }
//    public void clearTextFields (Container container){
//
//        for(Component c : container.getComponents()){
//            if(c instanceof JTextField){
//                JTextField f = (JTextField) c;
//                f.setText("");
//            }
//            else if (c instanceof Container)
//                clearTextFields((Container)c);
//        }
//    }
    public static void main(String[] args) {
        dashBoard panel = new dashBoard();

    }


}
