package Viewer;

import Controller.AdminController;
import Controller.JourneyController;
import Controller.RegisterController;
import DatabaseConnection.SqlServerConnection;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import java.time.LocalDate;

public class dashBoard extends javax.swing.JFrame {
    public JPanel dashPanel;
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
    private JLabel lblTest;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane5;
    private JTabbedPane tabbedPane6;
    private JTabbedPane tabbedPane7;
    private JTable tblEngine;
    private JTable tblBlock;
    private JScrollBar scrollBar1;

    public dashBoard() {


        JFrame frame = new JFrame("Dashboard");
        //frame.setUndecorated(true);
        frame.add(dashPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1200, 600);
        createTbl();
        createEngineTbl();


        //Full Screen
//        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
//
//        GraphicsDevice device = graphics.getDefaultScreenDevice();
//        JFrame frame = new JFrame("Dashboard");
//        frame.add(dashPanel);
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

                cbMonday.setSelected(false);
                cbTuesday.setSelected(false);
                cbWednesday.setSelected(false);
                cbThursday.setSelected(false);
                cbFriday.setSelected(false);
                cbSaturday.setSelected(false);
                cbSunday.setSelected(false);

                cmbJourneyType.removeAllItems();
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
                cmbBlockType.removeAllItems();
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
                if (txtTrainName.getText().equals("") || txtCapacity.getText().equals("")
                        || cmbType.getSelectedItem().equals(null)) {
                    JOptionPane.showMessageDialog(null, "Enter Data to all text fields", "Missing fields", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnDriverRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String DriverFullName = txtFullName.getText();
                String DriverUserName = txtDriver.getText();
                int DriverAge = Integer.parseInt(txtAge.getText());
                String DriverNIC = txtNIC.getText();
                int DriverContactNumber = Integer.parseInt(txtContactNumber.getText());
                String DriverEmail = txtEmail.getText();
                String DriverPassword = txtDriverPassword.getText();

                RegisterController driverRegisterController = new RegisterController();
                driverRegisterController.saveDriverReg(DriverFullName, DriverUserName, DriverAge, DriverNIC, DriverContactNumber, DriverEmail, DriverPassword);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String engineName = txtTrainName.getText();
                float engineCapacity = Float.parseFloat(txtCapacity.getText());
                String engineType = (String) cmbType.getSelectedItem();

                RegisterController engineRegisterControlleer = new RegisterController();
                engineRegisterControlleer.saveEngineReg(engineName, engineCapacity, engineType);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnBlockRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String BlockModel = txtBlock.getText();
                String BlockName = txtBlockName.getName();
                String BlockType = (String) cmbBlockType.getSelectedItem();

                float BlockLength = txtLength.getAlignmentX();
                float BlockWeight = txtWeight.getAlignmentX();
                int BlockCount = txtQuantity.getComponentCount();
                int BlockCapacity = txtCapacity.getComponentCount();

                RegisterController blockRegisterControlleer = new RegisterController();
                blockRegisterControlleer.saveBlockReg(BlockModel, BlockName, BlockType, BlockLength, BlockWeight, BlockCount, BlockCapacity);


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

                String journeyName = txtJourneyName.getText();
                float startingTime = Float.parseFloat(txtStartingTime.getText());
                float endTime = Float.parseFloat(txtEndTime.getText());
                int startingStation = Integer.parseInt(txtStartingStation.getText());
                int destination = Integer.parseInt(txtDestination.getText());
                LocalDate date = LocalDate.parse(txtDate.getText());
                String journeyType = (String) cmbJourneyType.getSelectedItem();
                String driverName = txtDriverNameJourney.getText();
                int engineID = Integer.parseInt(textField1.getText());
                int blockID = Integer.parseInt(txtBlockID.getText());
                int noOfBlocks = Integer.parseInt(txtNoOfBlocks.getText());

                JourneyController journeyController = new JourneyController();
                journeyController.createJourney(journeyName, startingTime, endTime, startingStation, destination, date, journeyType, driverName, engineID, blockID, noOfBlocks);

            }
        });
        btnCancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTrainName.setText("");
                txtCapacity.setText("");
                cmbType.removeAllItems();

            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String AdminFullName = txtAdminName.getText();
                String AdminUserName = txtAdminUsername.getText();
                String AdminNIC = txtAdminNIC.getText();
                int AdminContactNumber = Integer.parseInt(txtAdminPhone.getText());
                String AdminEmail = txtAdminEmail.getText();
                String AdminPassword = txtAdminPassword.getText();
                String AdminConfirmPassword = txtAdminConfirmPassword.getText();

                AdminController adminController = new AdminController();
                adminController.adminSignup(AdminFullName, AdminUserName, AdminNIC, AdminContactNumber, AdminEmail, AdminPassword);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int UpdatedJourneyID = Integer.parseInt(txtUpdatedJourneyID.getText());
                String UpdatedJourneyName = txtUpdatedJourneyName.getText();
                String UpdatedJourneyType = txtUpdatedJourneyType.getText();
                String UpdatedJourneyDriver = txtUpdatedJourneyDriver.getText();
                int UpdatedJourneyRouteID = Integer.parseInt(txtUpdatedJourneyRouteID.getText());
                int UpdatedJourneyTrainID = Integer.parseInt(txtUpdatedJourneyTrainID.getText());
                LocalDate UpdatedJourneyDate = LocalDate.parse(txtUpdatedJourneyDate.getText());
                float UpdatedJourneyStartingTime = Float.parseFloat(txtUpdatedJourneyStartingTime.getText());
                float UpdatedJourneyEndTime = Float.parseFloat(txtUpdatedJourneyEndingTime.getText());

                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();

                String qry="UPDATE ARCSDatabase.dbo.JourneyDetails SET JourneyName = '"+UpdatedJourneyName+"', JourneyType = '"+UpdatedJourneyType+"', DriverName='"+UpdatedJourneyDriver+"', RouteID='"+UpdatedJourneyRouteID+"', TrainID='"+UpdatedJourneyTrainID+"', JourneyStartTime='"+UpdatedJourneyStartingTime+"', JourneyEndTime='"+UpdatedJourneyEndTime+"'  WHERE JourneyID='"+UpdatedJourneyID+"';";

                try {
                    PreparedStatement ps = con.prepareStatement(qry);
                    ps.execute();

                    System.out.println("Ok");

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int UpdatedJourneyID = Integer.parseInt(txtUpdatedJourneyID.getText());

                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
                Connection con = objSqlServerConnection.createConnectionSqlServer();

                String qry="DELETE FROM ARCSDatabase.dbo.JourneyDetails WHERE JourneyID='"+UpdatedJourneyID+"';";
                try {
                    PreparedStatement ps = con.prepareStatement(qry);
                    ps.execute();

                    System.out.println("Ok");

                } catch (SQLException exception) {
                    exception.printStackTrace();
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
                lblTest.setText((String) tableModel.getValueAt(table1.getSelectedRow(),1));

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

    private void createTbl() {
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
                data[i][0] = String.valueOf(EngineID);
                data[i][1] = EngineName;
                data[i][2] = String.valueOf(EngineCapacity);
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
//                }
//
//            }

            public static void main(String[] args) {
                dashBoard panel = new dashBoard();
            }
}
