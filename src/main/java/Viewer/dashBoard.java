package Viewer;

import Controller.driverRegisterController;
import Controller.engineRegisterControlleer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dashBoard {
    private JPanel dashPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane4;
    private JTextField txtJourneyName;
    private JTextField txtStartingTime;
    private JTextField txtStartingStation;
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
    private JLabel lblDuration;
    private JLabel lblDistance;
    private JPanel lblEngineID;
    private JTextField txtBlock;
    private JTextField txtDriver;
    private JPasswordField txtDriverPassword;
    private JComboBox cmbBlockType;
    private JTextField txtBlockName;
    private JTextField txtDriverNameJourney;
    private JTextField textField1;
    private JButton button1;


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
                durationCalc();
//                txtJourneyName.setText("");
//                lblEngineID.setToolTipText("");
//                txtStartingTime.setText("");
//                txtEndTime.setText("");
//                txtStartingStation.setText("");
//                txtDestination.setText("");
//                lblDuration.setText("");
//                lblDistance.setText("");
//
//                cmbJourneyType.setToolTipText("");
//                txtBlockID.setText("");
//                txtNoOfBlocks.setText("");

            }
        });

        btnDriverCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDriver.setText("");
                txtFullName.setText("");
                txtAge.setText("");
                txtNIC.setText("");
                txtDriverPassword.setText("");
                txtContactNumber.setText("");
                txtEmail.setText("");
            }
        });
        btnBlockCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBlock.setText("");
                txtBlockName.setText("");
                cmbBlockType.setToolTipText("");
                txtLength.setText("");
                txtQuantity.setText("");
                txtWeight.setText("");
                txtCap.setText("");
            }
            });
//        btnCancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                        //clearTextFields(this.getContentPane());
//                        durationCalc();
//
//                        txtTrainName.setText("");
//                        txtCapacity.setText("");
//                        cmbType.setToolTipText("");
//
//                    }
//                });

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmbType.addItem("1");
               // item select keranne one so validate keranne ba
                if ( txtTrainName.getText().equals("") || txtCapacity.getText().equals("")
                        ||  cmbType.getSelectedItem().equals(null) )
                {
                        JOptionPane.showMessageDialog(null,"Enter Data to all text fields","Missing fields",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnDriverRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                driverRegisterController driverRegisterController = new driverRegisterController();
                //driverRegisterController.saveDriverReg(DriverRegistrationID, DriverFullName, DriverUserName, DriverAge, DriverNIC, DriverContactNumber, DriverEmail, DriverPassword);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engineRegisterControlleer engineRegisterControlleer = new engineRegisterControlleer();
                //engineRegisterControlleer.saveEngineReg();
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
            public void durationCalc() {
//        LocalDateTime stDate = LocalDateTime.parse(txtStartingTime.getText());
//        LocalDateTime eDate = LocalDateTime.parse(txtEndTime.getText());

//        String time1 = "16:00:00";
//        String time2 = "19:00:00";

                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date date1 = null;
                try {
                    date1 = format.parse(txtStartingTime.getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Date date2 = null;
                try {
                    date2 = format.parse(txtEndTime.getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (date1 instanceof Date || date2 instanceof Date) {
                    long difference = date2.getTime() - date1.getTime();
                    difference = difference / 60000;
                    if (difference < 0) {
                        difference = difference * (-1);
                        lblDuration.setText(String.valueOf(difference) + " Minutes");
                    } else {
                        lblDuration.setText(String.valueOf(difference) + " Minutes");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Time format", "Try again", JOptionPane.ERROR_MESSAGE);
                    txtStartingTime.setText("");
                    txtEndTime.setText("");
                }

            }

            public static void main(String[] args) {
                dashBoard panel = new dashBoard();

            }
}
