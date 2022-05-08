package Driver.Viewer_Driver;

import DatabaseConnection.SqlServerConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
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
    private JLabel counterLabel;

    Timer timer;
    Timer timer1;
    int hour, minute, second;
    int hour1, minute1, second1;
    String ddHour, ddMinute, ddSecond;
    String ddHour1, ddMinute1, ddSecond1;
    DecimalFormat dFormat = new DecimalFormat("00");

    public driverDashboard()
    {

        JFrame frame = new JFrame("Driver Dashboard");
        //frame.setUndecorated(true);
        frame.add(driverDashboardPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1550,700);
        driverBegin();
        Main();
        Main2();

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




    }
    public void driverBegin(){
        driverSignupModel dsm = new driverSignupModel();
        String driverUserName = dsm.getDriverUserName();

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.ViewJourneyByDriverName('"+driverUserName+"')}");
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
                lblViewDuration.setText(rs.getString("TimeDuration"));
                lblViewDate.setText(rs.getString("Date"));

                i++;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }



    }

    public void Main() {

        DateTimeFormatter h = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter m = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter s = DateTimeFormatter.ofPattern("ss");
        LocalTime now = LocalTime.now();

        counterLabel.setText("00:00:00");

        hour = Integer.parseInt(h.format(now));
        minute = Integer.parseInt(m.format(now));
        second = Integer.parseInt(s.format(now));

//        Time EndingTime = Time.valueOf(lblViewEndingTime.getName());
//        System.out.println(EndingTime);

        countdownTimer();
        timer.start();
    }

    public void countdownTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                ddHour = dFormat.format(hour);

                counterLabel.setText(ddHour + ":" + ddMinute + ":" + ddSecond);

                if(second==-1) {
                    second = 59;
                    minute--;

                    ddHour = dFormat.format(hour);
                    ddMinute = dFormat.format(minute);
                    ddHour = dFormat.format(hour);
                    counterLabel.setText(ddHour + ":" + ddMinute + ":" + ddSecond);

                }
                if(minute==-1) {
                    minute = 59;
                    hour--;
                    ddHour = dFormat.format(hour);
                    ddMinute = dFormat.format(minute);
                    ddHour = dFormat.format(hour);
                    counterLabel.setText(ddHour + ":" + ddMinute + ":" + ddSecond);
                }

                if(hour==0 && minute==0 && second==0) {
                    timer.stop();
                }
            }
        });
    }

    public void Main2() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();


        lblCurrentTime.setText((dtf.format(now)));

        DateTimeFormatter h = DateTimeFormatter.ofPattern("HH");
        DateTimeFormatter m = DateTimeFormatter.ofPattern("mm");
        DateTimeFormatter s = DateTimeFormatter.ofPattern("ss");


        lblCurrrentDate.setText(String.valueOf(LocalDate.now()));

        hour1 = Integer.parseInt(h.format(now));
        minute1 = Integer.parseInt(m.format(now));
        second1 = Integer.parseInt(s.format(now));

//        Time EndingTime = Time.valueOf(lblViewEndingTime.getName());
//        System.out.println(EndingTime);

        currentTimer();
        timer1.start();
    }

    public void currentTimer() {

        timer1 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second1++;
                ddSecond1 = dFormat.format(second1);
                ddMinute1 = dFormat.format(minute1);
                ddHour1 = dFormat.format(hour1);

                lblCurrentTime.setText(ddHour1 + ":" + ddMinute1 + ":" + ddSecond1);

                if(second1==60) {
                    second1 = 0;
                    minute1++;

                    ddHour1 = dFormat.format(hour1);
                    ddMinute1 = dFormat.format(minute1);
                    ddHour1 = dFormat.format(hour1);
                    lblCurrentTime.setText(ddHour1 + ":" + ddMinute1 + ":" + ddSecond1);

                }
                if(minute1==60) {
                    minute1 = 0;
                    hour1++;
                    ddHour1 = dFormat.format(hour1);
                    ddMinute1 = dFormat.format(minute1);
                    ddHour1 = dFormat.format(hour1);
                    lblCurrentTime.setText(ddHour1 + ":" + ddMinute1 + ":" + ddSecond1);
                }

                if(hour1==0 && minute1==0 && second1==0) {
                    timer1.stop();
                }
            }
        });
    }



    public static void main(String[] args) {
        new driverDashboard();
    }

}
