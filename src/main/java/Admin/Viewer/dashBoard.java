package Admin.Viewer;

import Admin.Controller.AdminController;
import Admin.Controller.JourneyController;
import Admin.Controller.RegisterController;
import DatabaseConnection.SqlServerConnection;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class dashBoard extends javax.swing.JFrame {
    public JPanel dashPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane4;
    private JTextField txtJourneyName;
    private JTextField txtStartingTime;
    private JTextField txtStartingStation;
    private JTextField txtBlockID1;
    private JTextField txtEndTime;
    private JTextField txtDestination;
    private JComboBox cmbJourneyType;
    private JTextField txtNoOfBlocks1;
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
    private JLabel lblDurationNew;
    private JLabel lblDistance;
    private JPanel lblEngineID;
    private JTextField txtBlock;
    private JTextField txtDriver;
    private JPasswordField txtDriverPassword;
    private JComboBox cmbBlockType;
    private JTextField txtBlockName;
    private JTextField txtDriverNameJourney;
    private JTextField textField1;
    private JTextField txtDate;
    private JPanel rootPannel;
    private JPanel tblPanel;
    private JTable table1;
    private JPanel panel1;
    private JTextField txtAdminUsername;
    private JTextField txtAdminEmail;
    private JTextField txtAdminPhone;
    private JPasswordField txtAdminPassword;
    private JPasswordField txtAdminConfirmPassword;
    private JButton signUpButton;
    private JButton clearButton;
    private JButton btnDelete;
    private JTextField txtUpdatedJourneyName;
    private JTextField txtUpdatedJourneyType;
    private JTextField txtUpdatedJourneyDriver;
    private JTextField txtUpdatedJourneyRouteID;
    private JTextField txtUpdatedJourneyTrainID;
    private JTextField txtUpdatedJourneyStartingTime;
    private JTextField txtUpdatedJourneyEndingTime;
    private JButton btnUpdate;
    private JTextField txtAdminName;
    private JTextField txtAdminNIC;
    private JTextField txtUpdatedJourneyID;
    private JTextField txtUpdatedJourneyDate;
    private JButton CLEARButton;
    private JButton sgnClearBtn;
    private JLabel lblViewJourneyName;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane5;
    private JTabbedPane tabbedPane6;
    private JTabbedPane tabbedPane7;
    private JTable tblEngine;
    private JTable tblBlock;
    private JTable tblDriver;
    private JProgressBar progressBarSpeed;
    private JPanel panelARCSDashboard;
    private JLabel lblAdminViewSpeed;
    private JButton btnTrainRegister;
    private JButton btnTrainRegistrationClear;
    private JTextField txtEngineID;
    private JTextField txtBlockID2;
    private JTextField txtBlockID3;
    private JTextField txtBlockCount1;
    private JTextField txtBlockCount2;
    private JTextField txtBlockCount3;
    private JTabbedPane tabbedPane8;
    private JTable tblTrain;
    private JLabel lblViewJourneyType;
    private JLabel lblViewJourneyID;
    private JLabel lblViewStartingStation;
    private JLabel lblViewDestination;
    private JLabel lblViewDistance;
    private JLabel lblViewStartingTime;
    private JLabel lblViewEndingTime;
    private JLabel lblViewDuration1;
    private JLabel lblViewDate;
    private JLabel lblViewDriverName;
    private JLabel lblViewDriverID;
    private JLabel lblViewDriverPhone;
    private JPanel panelDriver;
    private JLabel lblViewTrainID;
    private JLabel lblViewEngineID;
    private JTable tblUpdateJourney;
    private JLabel lblViewDuration;
    private JTextPane textPaneJourneyStatus;
    private JComboBox cmbStartingStation;
    private JComboBox cmbEndStation;
    private JLabel lblAdminCurrentTime;
    private JLabel lblAdminCurrrentDate;
    private JButton btnEmergency;
    private JButton btnStMap;
    private JButton btnTrackDriver;
    private JPanel pnl2;
    private JTextField txtNoOfBlocks2;
    private JTextField txtNoOfBlocks3;

    Timer timer1Admin;
    int hour1Admin, minute1Admin, second1Admin;
    String ddHour1Admin, ddMinute1Admin, ddSecond1Admin;
    DecimalFormat dFormat = new DecimalFormat("00");

    public dashBoard() {


        JFrame frame = new JFrame("Dashboard");
        //frame.setUndecorated(true);
        frame.add(dashPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1200, 600);
        //panelARCSDashboard.setSize(1200,50);
        createJourneyTbl();
        createEngineTbl();
        createBlockTbl();
        createDriverTbl();
        createTrainTbl();
        createUpdateJourneyrTbl();
        Main2Admin();
        viewPane();

        //Full Screen
//        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = graphics.getDefaultScreenDevice();
//        device.setFullScreenWindow(frame);




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
                txtDriverNameJourney.setText("");
                textField1.setText("");
                cmbJourneyType.removeAllItems();
                txtBlockID1.setText("");
                txtNoOfBlocks1.setText("");


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
                cmbBlockType.setSelectedItem("");
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


        btnDriverRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               // JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                if(txtFullName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtDriver.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAge.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtNIC.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtContactNumber.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtEmail.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtDriverPassword.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try {
                        String DriverFullName = txtFullName.getText();
                        String DriverUserName = txtDriver.getText();
                        int DriverAge = Integer.parseInt(txtAge.getText());
                        String DriverNIC = txtNIC.getText();
                        int DriverContactNumber = Integer.parseInt(txtContactNumber.getText());
                        String DriverEmail = txtEmail.getText();
                        String DriverPassword = txtDriverPassword.getText();

                        RegisterController driverRegisterController = new RegisterController();
                        boolean i = driverRegisterController.saveDriverReg(DriverFullName, DriverUserName, DriverAge, DriverNIC, DriverContactNumber, DriverEmail, DriverPassword);
                        if (!i) {
                            System.out.println("Data Successfully Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Driver Successfully Registered", " Registered!", JOptionPane.PLAIN_MESSAGE);

                            txtDriver.setText("");
                            txtFullName.setText("");
                            txtAge.setText("");
                            txtNIC.setText("");
                            txtDriverPassword.setText("");
                            txtContactNumber.setText("");
                            txtEmail.setText("");
                        } else {
                            System.out.println("Data Not Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Driver Registration", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if(txtTrainName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtCapacity.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
//                else if(cmbType.getSelectedItem().equals()){
//                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
//                }
                else{

                    try {
                        String engineName = txtTrainName.getText();
                        float engineCapacity = Float.parseFloat(txtCapacity.getText());
                        String engineType = (String) cmbType.getSelectedItem();

                        RegisterController engineRegisterControlleer = new RegisterController();
                        boolean i = engineRegisterControlleer.saveEngineReg(engineName, engineCapacity, engineType);

                        if (!i) {
                            System.out.println("Data Successfully Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Driver Successfully Registered", " Registered!", JOptionPane.PLAIN_MESSAGE);

                            txtTrainName.setText("");
                            txtCapacity.setText("");
                            cmbType.setSelectedItem("");

                        } else {
                            System.out.println("Data Not Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Driver Registration", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        btnBlockRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if(txtBlock.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
//                else if(cmbBlockType.getText().isEmpty()){
//                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
//                }
                else if(txtLength.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtWeight.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtQuantity.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtCapacity.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try {
                        String BlockModel = txtBlock.getText();
                        String BlockName = txtBlockName.getText();
                        String BlockType = (String) cmbBlockType.getSelectedItem();
                        float BlockLength = Float.parseFloat(txtLength.getText());
                        float BlockWeight = Float.parseFloat(txtWeight.getText());
                        int BlockCount = txtQuantity.getComponentCount();
                        int BlockCapacity = txtCapacity.getComponentCount();

                        RegisterController blockRegisterControlleer = new RegisterController();
                        boolean i = blockRegisterControlleer.saveBlockReg(BlockModel, BlockName, BlockType, BlockLength, BlockWeight, BlockCount, BlockCapacity);

                        if (!i) {
                            System.out.println("Data Successfully Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Block Successfully Registered", " Registered!", JOptionPane.PLAIN_MESSAGE);

                            txtBlock.setText("");
                            txtBlockName.setText("");
                            cmbBlockType.setSelectedItem("");
                            txtLength.setText("");
                            txtQuantity.setText("");
                            txtWeight.setText("");
                            txtCap.setText("");

                        } else {
                            System.out.println("Data Not Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Block Registration", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        cmbJourneyType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //durationCalc();

                if(txtJourneyName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtStartingTime.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtEndTime.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtDate.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtDriverNameJourney.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(textField1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }


                    else {

                        try {
                            String journeyName = txtJourneyName.getText();
                            Float startingTime = Float.valueOf(txtStartingTime.getText());
                            Float endTime = Float.valueOf(txtEndTime.getText());
                            String startingStation = (String) cmbStartingStation.getSelectedItem();
                            String destination = (String) cmbEndStation.getSelectedItem();
                            LocalDate date = LocalDate.parse(txtDate.getText());
                            String journeyType = (String) cmbJourneyType.getSelectedItem();
                            String driverName = txtDriverNameJourney.getText();
                            int trainID = Integer.parseInt(textField1.getText());

                            JourneyController journeyController = new JourneyController();

                            boolean i = journeyController.createJourney(journeyName, startingTime, endTime, startingStation, destination, date, journeyType, driverName, trainID);
                            if (!i) {
                                System.out.println("Data Successfully Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Journey Created Successfully", " Created!", JOptionPane.PLAIN_MESSAGE);

                                txtJourneyName.setText("");
                                txtStartingTime.setText("");
                                txtEndTime.setText("");
                                txtDate.setText("");
                                txtDriverNameJourney.setText("");
                                textField1.setText("");
                                cmbStartingStation.setSelectedItem("");
                                cmbEndStation.setSelectedItem("");
                                cmbJourneyType.setSelectedItem("");

                            } else {
                                System.out.println("Data Not Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Journey Creation", "Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

            }
        });
        btnCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTrainName.setText("");
                txtCapacity.setText("");
                cmbType.setSelectedItem("");

            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtAdminName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminUsername.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminNIC.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminPhone.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminEmail.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminPassword.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtAdminConfirmPassword.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try {
                        String AdminFullName = txtAdminName.getText();
                        String AdminUserName = txtAdminUsername.getText();
                        String AdminNIC = txtAdminNIC.getText();
                        int AdminContactNumber = Integer.parseInt(txtAdminPhone.getText());
                        String AdminEmail = txtAdminEmail.getText();
                        String AdminPassword = txtAdminPassword.getText();
                        String AdminConfirmPassword = txtAdminConfirmPassword.getText();

                        AdminController adminController = new AdminController();
                        boolean i = adminController.adminSignup(AdminFullName, AdminUserName, AdminNIC, AdminContactNumber, AdminEmail, AdminPassword);

                        if (!i) {
                            System.out.println("Data Successfully Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Admin Successfully Registered", " Registered!", JOptionPane.PLAIN_MESSAGE);

                            txtAdminName.setText("");
                            txtAdminUsername.setText("");
                            txtAdminNIC.setText("");
                            txtAdminPhone.setText("");
                            txtAdminEmail.setText("");
                            txtAdminPassword.setText("");
                            txtAdminConfirmPassword.setText("");

                        } else {
                            System.out.println("Data Not Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Admin Registration", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtUpdatedJourneyID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyType.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyDriver.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyRouteID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyTrainID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyDate.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyStartingTime.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtUpdatedJourneyEndingTime.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try{
                        int UpdatedJourneyID = Integer.parseInt(txtUpdatedJourneyID.getText());
                        String UpdatedJourneyName = txtUpdatedJourneyName.getText();
                        String UpdatedJourneyType = txtUpdatedJourneyType.getText();
                        String UpdatedJourneyDriver = txtUpdatedJourneyDriver.getText();
                        int UpdatedJourneyRouteID = Integer.parseInt(txtUpdatedJourneyRouteID.getText());
                        int UpdatedJourneyTrainID = Integer.parseInt(txtUpdatedJourneyTrainID.getText());
                        LocalDate UpdatedJourneyDate = LocalDate.parse(txtUpdatedJourneyDate.getText());
                        LocalTime UpdatedJourneyStartingTime = LocalTime.parse(txtUpdatedJourneyStartingTime.getText());
                        LocalTime UpdatedJourneyEndTime = LocalTime.parse(txtUpdatedJourneyEndingTime.getText());

                        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                        Connection con = objSqlServerConnection.createConnectionSqlServer();

                        String qry="UPDATE ARCSDatabase.dbo.JourneyDetails SET JourneyName = '"+UpdatedJourneyName+"', JourneyType = '"+UpdatedJourneyType+"', DriverName='"+UpdatedJourneyDriver+"', RouteID='"+UpdatedJourneyRouteID+"', TrainID='"+UpdatedJourneyTrainID+"', JourneyStartTime='"+UpdatedJourneyStartingTime+"', JourneyEndTime='"+UpdatedJourneyEndTime+"'  WHERE JourneyID='"+UpdatedJourneyID+"';";

                        try {
                            PreparedStatement ps = con.prepareStatement(qry);
                            boolean i = ps.execute();

                            if (!i) {
                                createUpdateJourneyrTbl();
                                System.out.println("Data Successfully Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Journey Successfully Updated", " Registered!", JOptionPane.PLAIN_MESSAGE);

                                txtUpdatedJourneyID.setText("");
                                txtUpdatedJourneyName.setText("");
                                txtUpdatedJourneyType.setText("");
                                txtUpdatedJourneyDriver.setText("");
                                txtUpdatedJourneyRouteID.setText("");
                                txtUpdatedJourneyTrainID.setText("");
                                txtUpdatedJourneyDate.setText("");
                                txtUpdatedJourneyStartingTime.setText("");
                                txtUpdatedJourneyEndingTime.setText("");

                            } else {
                                System.out.println("Data Not Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Unsuccessful", "Error!", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtUpdatedJourneyID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    try{
                        int UpdatedJourneyID = Integer.parseInt(txtUpdatedJourneyID.getText());

                        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                        Connection con = objSqlServerConnection.createConnectionSqlServer();

                        String qry="DELETE FROM ARCSDatabase.dbo.JourneyDetails WHERE JourneyID='"+UpdatedJourneyID+"';";

                        try {
                            PreparedStatement ps = con.prepareStatement(qry);
                            boolean i = ps.execute();

                            if (!i) {
                                createUpdateJourneyrTbl();
                                System.out.println("Data Successfully Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Journey Successfully Deleted", " Registered!", JOptionPane.PLAIN_MESSAGE);

                                txtUpdatedJourneyID.setText("");
                                txtUpdatedJourneyName.setText("");
                                txtUpdatedJourneyType.setText("");
                                txtUpdatedJourneyDriver.setText("");
                                txtUpdatedJourneyRouteID.setText("");
                                txtUpdatedJourneyTrainID.setText("");
                                txtUpdatedJourneyDate.setText("");
                                txtUpdatedJourneyStartingTime.setText("");
                                txtUpdatedJourneyEndingTime.setText("");

                            } else {
                                System.out.println("Data Not Registered");
                                JOptionPane.showMessageDialog(dashPanel, "Unsuccessful", "Error!", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (SQLException exception) {
                            exception.printStackTrace();
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUpdatedJourneyID.setText("");
                txtUpdatedJourneyName.setText("");
                txtUpdatedJourneyType.setText("");
                txtUpdatedJourneyDriver.setText("");
                txtUpdatedJourneyRouteID.setText("");
                txtUpdatedJourneyTrainID.setText("");
                txtUpdatedJourneyDate.setText("");
                txtUpdatedJourneyStartingTime.setText("");
                txtUpdatedJourneyEndingTime.setText("");
            }
        });
        sgnClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAdminName.setText("");
                txtAdminUsername.setText("");
                txtAdminNIC.setText("");
                txtAdminPhone.setText("");
                txtAdminEmail.setText("");
                txtAdminPassword.setText("");
                txtAdminConfirmPassword.setText("");

            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel tableModel = (DefaultTableModel)table1.getModel();
                String JourneyID = (String) tableModel.getValueAt(table1.getSelectedRow(),0);


                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();


                try {

                    CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.ViewJourneyByJourneyID('"+JourneyID+"')}");
                    ResultSet rs = cs.executeQuery();

                    int i = 0;
                    while (rs.next()) {

                        lblViewJourneyName.setText(rs.getString("JourneyName"));
                        lblViewJourneyType.setText(rs.getString("JourneyType"));
                        lblViewJourneyID.setText(String.valueOf(rs.getString("JourneyID")));
                        lblViewStartingStation.setText(rs.getString("StartStationName"));
                        lblViewDestination.setText(rs.getString("EndStationName"));
                        lblViewStartingTime.setText(rs.getString("JourneyStartTime"));
                        lblViewEndingTime.setText(rs.getString("JourneyEndTime"));
                        lblViewDate.setText(rs.getString("Date"));
                        lblViewDriverName.setText(rs.getString("DriverFullName"));
                        lblViewDriverID.setText(rs.getString("DriverID"));
                        lblViewDriverPhone.setText(rs.getString("DriverContactNumber"));
                        lblViewTrainID.setText(rs.getString("TrainID"));
                        lblViewEngineID.setText(rs.getString("EngineID"));

                        float Duration = rs.getFloat("Duration");
                        float Distance = rs.getFloat("Distance");
                        float AverageSpeed = rs.getFloat("AverageSpeed");

                        lblDurationNew.setText(Duration + " hours");
                        lblViewDistance.setText(Distance + " km");
                        lblAdminViewSpeed.setText(AverageSpeed + " km/h");

                        for (int j = 0; j <= AverageSpeed; j++) {

                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }

                            progressBarSpeed.setValue(j);
                        }


                        i++;
                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });
        btnTrainRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(txtEngineID.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockID1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockID2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockID3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockCount1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockCount2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }
                else if(txtBlockCount3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(dashPanel, "Missing Fields!", "Try Again!", JOptionPane.ERROR_MESSAGE);
                }

                else{

                    try {
                        int engineID = Integer.parseInt(txtEngineID.getText());
                        int blockID1 = Integer.parseInt(txtBlockID1.getText());
                        int blockID2 = Integer.parseInt(txtBlockID2.getText());
                        int blockID3 = Integer.parseInt(txtBlockID3.getText());
                        int noOfBlocks1 = Integer.parseInt(txtBlockCount1.getText());
                        int noOfBlocks2 = Integer.parseInt(txtBlockCount2.getText());
                        int noOfBlocks3 = Integer.parseInt(txtBlockCount3.getText());

                        RegisterController registerController = new RegisterController();
                        boolean i = registerController.saveTrainReg(engineID, blockID1,blockID2,blockID3, noOfBlocks1,noOfBlocks2,noOfBlocks3);

                        if (!i) {
                            System.out.println("Data Successfully Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Driver Successfully Registered", " Registered!", JOptionPane.PLAIN_MESSAGE);

                            txtEngineID.setText("");
                            txtBlockID1.setText("");
                            txtBlockID2.setText("");
                            txtBlockID3.setText("");
                            txtBlockCount1.setText("");
                            txtBlockCount2.setText("");
                            txtBlockCount3.setText("");

                        } else {
                            System.out.println("Data Not Registered");
                            JOptionPane.showMessageDialog(dashPanel, "Unsuccessful Driver Registration", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

            }
        });
        btnTrainRegistrationClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtEngineID.setText("");
                txtBlockID1.setText("");
                txtBlockID2.setText("");
                txtBlockID3.setText("");
                txtNoOfBlocks1.setText("");
                txtNoOfBlocks2.setText("");
                txtNoOfBlocks3.setText("");
            }
        });
        tblUpdateJourney.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel tableModel = (DefaultTableModel)tblUpdateJourney.getModel();
                txtUpdatedJourneyID.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),0));
                txtUpdatedJourneyName.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),1));
                txtUpdatedJourneyType.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),2));
                txtUpdatedJourneyDriver.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),4));
                txtUpdatedJourneyRouteID.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),5));
                txtUpdatedJourneyTrainID.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),6));
                txtUpdatedJourneyDate.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),3));
                txtUpdatedJourneyStartingTime.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),7));
                txtUpdatedJourneyEndingTime.setText((String) tableModel.getValueAt(tblUpdateJourney.getSelectedRow(),8));

            }
        });
        btnStMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/main/java/Admin/Viewer/ARCSMap.html");
                if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
                {
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists())         //checks file exists or not
                {
                    try {
                        desktop.open(file);              //opens the specified file
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

        });
        btnTrackDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/main/java/Admin/Viewer/geolocation/index.html");
                if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
                {
                    System.out.println("Browser not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists())         //checks file exists or not
                {
                    try {
                        desktop.open(file);              //opens the specified file
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        pnl2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                createJourneyTbl();
            }
        });
    }

    public int rowCountJourney() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(JourneyID) FROM [ARCSDatabase].[dbo].[JourneyDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void createJourneyTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [ARCSDatabase].[dbo].[JourneyDetails]");

            int RowCount = rowCountJourney();

            String columns[] = {"Journey ID", "Name", "Journey Status"};
            String data[][] = new String[RowCount][3];

            int i = 0;
            while (rs.next()) {
                int id = rs.getInt("JourneyID");
                String name = rs.getString("JourneyName");
                String sts = rs.getString("JourneyStatus");
                data[i][0] = id + "";
                data[i][1] = name;
                data[i][2] = sts;
                i++;
            }
            table1.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int rowCountEngine() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(EngineID) FROM [ARCSDatabase].[dbo].[TrainEngineDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createEngineTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [ARCSDatabase].[dbo].[TrainEngineDetails]");

            int RowCount = rowCountEngine();

            String columns[] = {"Engine ID", "Engine Name", "Engine Capacity", "Engine Type"};
            String data[][] = new String[RowCount][4];

            int i = 0;
            while (rs.next()) {

                int EngineID = rs.getInt("EngineID");
                String EngineName = rs.getString("EngineName");
                Float EngineCapacity = rs.getFloat("EngineCapacity");
                String EngineType = rs.getString("EngineType");
                data[i][0] = EngineID + "";
                data[i][1] = EngineName;
                data[i][2] = EngineCapacity + "";
                data[i][3] = EngineType;
                i++;
            }
            tblEngine.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertEngineDetails(?,?,?)}");
    //PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
    public int rowCountBlock() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(BlockID) FROM [ARCSDatabase].[dbo].[TrainBlockDetails]");

            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createBlockTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [ARCSDatabase].[dbo].[TrainBlockDetails]");

            int RowCount = rowCountBlock();

            String columns[] = {"Block ID", "Block Name", "BlockType", "Block Admin.Model", "Block Length", "Block Weight", "Block Capacity", "Available Block Count", "Registered Block Count"};
            String data[][] = new String[RowCount][9];

            int i = 0;
            while (rs.next()) {
                int BlockID = rs.getInt("BlockID");
                String BlockName = rs.getString("BlockName");
                String BlockModel = rs.getString("BlockModel");
                String BlockType = rs.getString("BlockType");
                Float BlockLength = rs.getFloat("BlockLength");
                Float BlockWeight = rs.getFloat("BlockWeight");
                int BlockCapacity = rs.getInt("BlockCapacity");
                int AvailableBlockCount = rs.getInt("AvailableBlockCount");
                int RegisteredBlockCount = rs.getInt("RegisteredBlockCount");

                data[i][0] = String.valueOf(BlockID);
                data[i][1] = BlockName;
                data[i][2] = BlockModel;
                data[i][3] = BlockType;
                data[i][4] = String.valueOf(BlockLength);
                data[i][5] = String.valueOf(BlockWeight);
                data[i][6] = String.valueOf(BlockCapacity);
                data[i][7] = String.valueOf(AvailableBlockCount);
                data[i][8] = String.valueOf(RegisteredBlockCount);
                i++;
            }
            tblBlock.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int rowCountDriver() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(DriverID) FROM [ARCSDatabase].[dbo].[DriverDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createDriverTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [ARCSDatabase].[dbo].[DriverDetails]");

            int RowCount = rowCountDriver();

            String columns[] = {"DriverID", "Name", "Username", "Age", "NIC", "ContactNumber", "Email", "Password"};
            String data[][] = new String[RowCount][8];

            int i = 0;
            while (rs.next()) {
                int DriverID = rs.getInt("DriverID");
                String DriverFullName = rs.getString("DriverFullName");
                String DriverUserName = rs.getString("DriverUserName");
                int DriverAge = rs.getInt("DriverAge");
                String DriverNIC = rs.getString("DriverNIC");
                int DriverContactNumber = rs.getInt("DriverContactNumber");
                String DriverEmail = rs.getString("DriverEmail");
                String DriverPassword = rs.getString("DriverPassword");

                data[i][0] = DriverID+"";
                data[i][1] = DriverFullName;
                data[i][2] = DriverUserName;
                data[i][3] = DriverAge + "";
                data[i][4] = DriverNIC;
                data[i][5] = DriverContactNumber + "";
                data[i][6] = DriverEmail;
                data[i][7] = DriverPassword;
                i++;
            }
            tblDriver.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int rowCountTrain() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(TrainID) FROM [ARCSDatabase].[dbo].[TrainDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createTrainTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.GetAllTrainDetails}");
            ResultSet rs = cs.executeQuery();

            int RowCount = rowCountTrain();

            String columns[] = {"Train ID", "Engine ID","Block ID 01", "No of Blocks 01","Block ID 02", "No of Blocks 02", "Block ID 03", "No of Blocks 03", "Train Location"};
            String data[][] = new String[15][9];

            int i = 0;
            while (rs.next()) {
                int TrainID = rs.getInt("TrainID");
                int EngineID = rs.getInt("EngineID");
                int BlockID1 = rs.getInt("BlockID1");
                int BlockCount1 = rs.getInt("BlockCount1");
                int BlockID2 = rs.getInt("BlockID2");
                int BlockCount2 = rs.getInt("BlockCount2");
                int BlockID3 = rs.getInt("BlockID3");
                int BlockCount3 = rs.getInt("BlockCount3");
                String TrainLocation = rs.getString("TrainLocation");


                data[i][0] = TrainID + "";
                data[i][1] = EngineID + "";
                data[i][4] = BlockID2 + "";
                data[i][2] = BlockID1 + "";
                data[i][3] = BlockCount1 + "";
                data[i][5] = BlockCount2 + "";
                data[i][6] = BlockID3 + "";
                data[i][7] = BlockCount3 + "";
                data[i][8] = TrainLocation;
                i++;
            }
            tblTrain.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int rowCountUpdateJourney() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(JourneyID) FROM [ARCSDatabase].[dbo].[JourneyDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void createUpdateJourneyrTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [ARCSDatabase].[dbo].[JourneyDetails]");

            int RowCount = rowCountUpdateJourney();

            String columns[] = {"Journey ID", "Journey Name", "Journey Type", "Date", "Driver Name", "Route ID", "Train ID", "Journey Start Time", "Journey End Time", "Journey Status"};
            String data[][] = new String[RowCount][10];

            int i = 0;
            while (rs.next()) {
                int JourneyID = rs.getInt("JourneyID");
                String JourneyName = rs.getString("JourneyName");
                String JourneyType = rs.getString("JourneyType");
                String Date = rs.getString("Date");
                String DriverName = rs.getString("DriverName");
                int RouteID = rs.getInt("RouteID");
                int TrainID = rs.getInt("TrainID");
                String JourneyStartTime = rs.getString("JourneyStartTime");
                String JourneyEndTime = rs.getString("JourneyEndTime");
                int JourneyStatus = rs.getInt("JourneyStatus");

                data[i][0] = JourneyID+"";
                data[i][1] = JourneyName;
                data[i][2] = JourneyType;
                data[i][3] = Date;
                data[i][4] = DriverName;
                data[i][5] = RouteID + "";
                data[i][6] = TrainID + "";
                data[i][7] = JourneyStartTime + "";
                data[i][8] = JourneyEndTime + "";
                data[i][9] = JourneyStatus + "";
                i++;
            }
            tblUpdateJourney.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
//            public void durationCalc() {
//        LocalDateTime stDate = LocalDateTime.parse(txtStartingTime.getText());
//        LocalDateTime eDate = LocalDateTime.parse(txtEndTime.getText());
//
//        String time1 = "16:00:00";
//        String time2 = "19:00:00";
//
//                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//                Date date1 = null;
//                try {
//                    date1 = format.parse(txtStartingTime.getText());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                Date date2 = null;
//                try {
//                    date2 = format.parse(txtEndTime.getText());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                if (date1 instanceof Date || date2 instanceof Date) {
//                    long difference = date2.getTime() - date1.getTime();
//                    difference = difference / 60000;
//                    if (difference < 0) {
//                        difference = difference * (-1);
//                        lblDuration.setText(String.valueOf(difference) + " Minutes");
//                    } else {
//                        lblDuration.setText(String.valueOf(difference) + " Minutes");
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Incorrect Time format", "Try again", JOptionPane.ERROR_MESSAGE);
//                    txtStartingTime.setText("");
//                    txtEndTime.setText("");
//                }itch
//
//            }


    public void Main2Admin() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();


        lblAdminCurrentTime.setText((dtf.format(now)));

        DateTimeFormatter h = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter m = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter s = DateTimeFormatter.ofPattern("ss");


        lblAdminCurrrentDate.setText(String.valueOf(LocalDate.now()));

        hour1Admin = Integer.parseInt(h.format(now));
        minute1Admin = Integer.parseInt(m.format(now));
        second1Admin = Integer.parseInt(s.format(now));

//        Time EndingTime = Time.valueOf(lblViewEndingTime.getName());
//        System.out.println(EndingTime);

        currentTimer();
        timer1Admin.start();
    }

    public void currentTimer() {

        timer1Admin = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second1Admin++;
                ddSecond1Admin = dFormat.format(second1Admin);
                ddMinute1Admin = dFormat.format(minute1Admin);
                ddHour1Admin = dFormat.format(hour1Admin);

                lblAdminCurrentTime.setText(ddHour1Admin + ":" + ddMinute1Admin + ":" + ddSecond1Admin);

                if(second1Admin==60) {
                    second1Admin = 0;
                    minute1Admin++;

                    ddHour1Admin = dFormat.format(hour1Admin);
                    ddMinute1Admin = dFormat.format(minute1Admin);
                    ddHour1Admin = dFormat.format(hour1Admin);
                    lblAdminCurrentTime.setText(ddHour1Admin + ":" + ddMinute1Admin + ":" + ddSecond1Admin);

                }
                if(minute1Admin==60) {
                    minute1Admin = 0;
                    hour1Admin++;
                    ddHour1Admin = dFormat.format(hour1Admin);
                    ddMinute1Admin = dFormat.format(minute1Admin);
                    ddHour1Admin = dFormat.format(hour1Admin);
                    lblAdminCurrentTime.setText(ddHour1Admin + ":" + ddMinute1Admin + ":" + ddSecond1Admin);
                }

                if(hour1Admin==0 && minute1Admin==0 && second1Admin==0) {
                    timer1Admin.stop();
                }
            }
        });
    }



    public void alertMethod(int alertVal, String btnAction) {

        switch(alertVal)
        {
            case 1:
                System.out.println(btnAction);break;
            case 2:
                System.out.println(btnAction);break;
        }

    }

    private void viewPane()
    {
        textPaneJourneyStatus.setText("" +
                "");
    }



    public static void main(String[] args) {
        dashBoard panel = new dashBoard();
    }
}
