package Driver.Viewer_Driver;

import DatabaseConnection.SqlServerConnection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import Driver.Model_Driver.driverSignupModel;
import Admin.Viewer.dashBoard;

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
    private JButton btnEmergency;
    private JButton btnStation1;
    private JButton btnStation2;
    private JButton btnStation3;
    private JLabel lblCurrentSpeed;
    private JLabel lblRequiredSpeed;

    Timer timer;
    Timer timer1;
    int hour, minute, second;
    int hour1, minute1, second1;
    String ddHour, ddMinute, ddSecond;
    String ddHour1, ddMinute1, ddSecond1;
    DecimalFormat dFormat = new DecimalFormat("00");
    int timenow;

    String clickSound;
    ButtonHandler bHandler = new ButtonHandler();
    SoundEffect se = new SoundEffect();

    String btnAction;
    int alertVal;

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
        Sound();
        calculateLiveSpeed();

        //Full Screen
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        device.setFullScreenWindow(frame);

        for (int i = 0; i <= 70; i++) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblSpeed.setText(i + "km/h");
            progressBarAverageSpeed.setValue(i);
        }



        btnEmergency.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btnAction = "Emergency alert from Journey "+lblViewJourneyID.getText();
                alertVal=1;
                dashBoard ds = new dashBoard();
                ds.setVisible(false);
                ds.alertMethod(alertVal,btnAction);
                btnEmergency.disable();
                btnEmergency.setText("Emergency Mode Active");

            }
        });
        journeyStartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                LocalTime now = LocalTime.now();
//                DateTimeFormatter time = DateTimeFormatter.ofPattern("mm:ss");
//                timenow = Integer.parseInt(time.format(now));
                driverSignupModel dsm = new driverSignupModel();
                String driverUserName = dsm.getDriverUserName();

                btnAction = driverUserName+" started Journey "+lblViewJourneyID.getText();
                alertVal=2;
            }
        });
        btnStation1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

//                String startTime = lblViewStartingTime.getText();
//                String endTime = lblViewEndingTime.getText();
//                String currentTime = lblCurrentTime.getText();
//
//                String start = lblViewStartingStation.getText();
//                String end = lblViewDestination.getText();
//                int current = 1;
//
//                SqlServerConnection objSqlServerConnection = new SqlServerConnection();
//                Connection con = objSqlServerConnection.createConnectionSqlServer();
//
//                try {
//                    CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.DistanceCalculation(?,?)}");
//                    ResultSet rs = cs.executeQuery();
//
//                    int i = 0;
//                    while (rs.next()) {
//
//                        lblViewStartingStation.setText(rs.getString("StartingStationName"));
//                        lblViewDestination.setText(rs.getString("EndStationName"));
//
//                        i++;
//                    }
//
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//
//
//                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//                try {
//                    java.util.Date time3 = format.parse(endTime);
//                    java.util.Date time2 = format.parse(currentTime);
//                    java.util.Date time1 = format.parse(startTime);
//
//                    long CurrenttimeDifference = ((time2.getTime() - time1.getTime())/ 1000) / 60;
//                    long CurrentdiffDistance = current - start;
//                    long liveSpeed = (CurrentdiffDistance*60) / CurrenttimeDifference;
//
//                    //lblCurrentSpeed.setText(String.valueOf(liveSpeed));
//                    if (liveSpeed < 0)
//                        liveSpeed = -liveSpeed;
//
//                    for (int i = 0; i <= liveSpeed; i++) {
//
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException y) {
//                            y.printStackTrace();
//                        }
//                        lblCurrentSpeed.setText(i + "km/h");
//                        //progressBarAverageSpeed.setValue(i);
//                    }
//
//
//                    long RequiredtimeDifference = ((time3.getTime() - time2.getTime())/ 1000) / 60;
//                    long RequireddiffDistance = end - current;
//                    long RequiredSpeed = (RequireddiffDistance*60) / RequiredtimeDifference;
//
//                    //lblRequiredSpeed.setText(String.valueOf(RequiredSpeed));
//
//                    if (RequiredSpeed < 0)
//                        RequiredSpeed = -RequiredSpeed;
//
//                    for (int i = 0; i <= RequiredSpeed; i++) {
//
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException y) {
//                            y.printStackTrace();
//                        }
//                        lblRequiredSpeed.setText(i + "km/h");
//                        //progressBarAverageSpeed.setValue(i);
//                    }
//
//                } catch (Exception x) {
//                    x.printStackTrace();
//                }

            }
        });
    }
    public void driverBegin(){


        driverSignupModel dsm = new driverSignupModel();

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        String x = String.valueOf(Integer.parseInt(String.valueOf(dsm.getJourneyID())));
        System.out.println("driver dash id check "+x);


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.ViewDriversJourneyByJourneyID('"+x+"')}");
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



    public void Sound(){


        btnEmergency.setFocusPainted(false);
        btnEmergency.addActionListener(bHandler);
        btnEmergency.setActionCommand("soundB");

        clickSound = "C:\\Users\\Dell\\Downloads\\alar.wav";


    }

    public class SoundEffect {

        Clip clip;

        public void setFile(String soundFileName){

            try{
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
            catch(Exception e){

            }
        }

        public void play(){

            clip.setFramePosition(0);
            clip.start();
        }

    }

    public class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            se.setFile(clickSound);
            se.play();
        }
    }



    public void calculateLiveSpeed()
    {
//        Time CurrentTime = Time.valueOf(lblCurrentTime.getText());
//        System.out.println(CurrentTime);
//
//        Time y = Time.valueOf(lblCurrentTime.getText());
//        System.out.println(y);
//
//        Time x = CurrentTime - y;

        String startTime = "9:00:00";
        String endTime = "16:00:00";
        String currentTime = "13:00:00";

        int start = 10;
        int end = 1010;
        int current = 410;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            java.util.Date time3 = format.parse(endTime);
            java.util.Date time2 = format.parse(currentTime);
            java.util.Date time1 = format.parse(startTime);

            long CurrenttimeDifference = ((time2.getTime() - time1.getTime())/ 1000) / 60;
            long CurrentdiffDistance = current - start;
            long liveSpeed = (CurrentdiffDistance*60) / CurrenttimeDifference;
            System.out.println("Live Speed :"+liveSpeed);

            long RequiredtimeDifference = ((time3.getTime() - time2.getTime())/ 1000) / 60;
            long RequireddiffDistance = end - current;
            long RequiredSpeed = (RequireddiffDistance*60) / RequiredtimeDifference;
            System.out.println("Required Speed :"+RequiredSpeed);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {
        new driverDashboard();
    }

}