package ConsoleLog;

import javax.swing.*;

public class alertPopup {
    private JPanel panel1;
    public JLabel lblAlert;

    public alertPopup()
    {
        JFrame frame = new JFrame("Alert");
        //frame.setUndecorated(true);
        frame.add(panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(950,400);
    }
    public void alertset(){
        logModel lg = new logModel();
        lblAlert.setText(lg.getAlertText());
    }

    public static void main(String[] args) {

        new alertPopup();
    }
}
