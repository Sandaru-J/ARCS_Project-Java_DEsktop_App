package Viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
                //clearTextFields(this.getContentPane());
                durationCalc();
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
    public void durationCalc()
    {
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
            date2 = format.parse(txtEndTime.getText() );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if( date1 instanceof Date || date2 instanceof Date )
        {
            long difference = date2.getTime() - date1.getTime();
            difference=difference/60000;
            if(difference < 0)
            {
                difference = difference * (-1);
                lblDuration.setText(String.valueOf(difference)+" Minutes");
            }else
            {
                lblDuration.setText(String.valueOf(difference)+" Minutes");
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"Incorrect Time format","Try again",JOptionPane.ERROR_MESSAGE);
            txtStartingTime.setText("");
            txtEndTime.setText("");
        }

    }
    public static void main(String[] args) {
        dashBoard panel = new dashBoard();

    }


}
