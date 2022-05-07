package Driver.Viewer_Driver;

import DatabaseConnection.SqlServerConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import Driver.Model_Driver.driverSignupModel;

public class driverDashboard {
    private JLabel lblViewJourneyName;
    private JLabel lblViewJourneyID;
    private JLabel lblViewJourneyType;
    private JLabel lblViewDestination;
    private JLabel lblViewStartingStation;
    private JLabel lblViewDistance;
    private JLabel lblViewStartingTime;
    private JLabel lblViewEndingTime;
    private JLabel lblViewDuration;
    private JLabel lblViewDate;
    private JProgressBar progressBarAverageSpeed;
    private JLabel lblSpeed;
    private JPanel driverDashboardPanel;
    private JLabel lblCurrentTime;
    private JLabel lblCurrrentDate;
    private JButton journeyStartButton;

    public driverDashboard()
    {

        JFrame frame = new JFrame("Driver Dashboard");
        //frame.setUndecorated(true);
        frame.add(driverDashboardPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1550,700);

        //Full Screen
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(frame);

        for (int i = 0; i <= 70; i++) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblSpeed.setText(i + "km/h");
            progressBarAverageSpeed.setValue(i);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();
        System.out.println(dtf.format(now));

        lblCurrrentDate.setText(String.valueOf(LocalDate.now()));
        lblCurrentTime.setText((dtf.format(now)));


    }
    public void driverBegin(){
        driverSignupModel dsm = new driverSignupModel();
        String driverUserName=dsm.getDriverUserName();

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.ViewJourneyByJourneyID(2)}");
            ResultSet rs = cs.executeQuery();

            int i = 0;
            while (rs.next()) {
//
                lblViewJourneyName.setText(rs.getString("JourneyName"));
                lblViewJourneyType.setText(rs.getString("JourneyType"));
                lblViewJourneyID.setText(String.valueOf(rs.getString("JourneyID")));
                lblViewStartingStation.setText(rs.getString("StartStationName"));
                lblViewDestination.setText(rs.getString("EndStationName"));
                lblViewStartingTime.setText(rs.getString("JourneyStartTime"));
                lblViewEndingTime.setText(rs.getString("JourneyEndTime"));
                lblViewDuration.setText(rs.getString("TimeDuration"));
                lblViewDate.setText(rs.getString("Date"));

                i++;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new driverDashboard();
    }

}
