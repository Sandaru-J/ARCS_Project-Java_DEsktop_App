package Driver.Viewer_Driver;

import javax.swing.*;

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

    public driverDashboard()
    {

        JFrame frame = new JFrame("Driver Dashboard");
        //frame.setUndecorated(true);
        frame.add(driverDashboardPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1550,700);

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

    public static void main(String[] args) {
        new driverDashboard();
    }
}
