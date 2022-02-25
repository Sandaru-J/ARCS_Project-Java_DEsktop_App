package Viewer;

import javax.swing.*;

public class createJourney extends JFrame {
    private JButton btnCreateJourney;
    private JButton btnCancel;
    private JTextField txtJName;
    private JTextField txtJId;
    private JTextField txtStartTime;
    private JTextField txtStartStation;
    private JTextField txtDestination;
    private JTextField txtEndTime;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextField txtTrainId;
    private JComboBox cmbJourneyType;
    private JCheckBox chekMonday;
    private JCheckBox chekTuesday;
    private JCheckBox chekWednesday;
    private JCheckBox chekThursday;
    private JCheckBox chekFriday;
    private JCheckBox chekSaturday;
    private JCheckBox chekSunday;
    private JTextField txtDriverId;
    private JTextField txtEngineId;
    private JTextField txtBlockId;
    private JTextField TxtNoofBlocks;
    private JPanel mainPnael;
    private JPanel headerPanel;


    public createJourney(){
        JFrame frame = new JFrame("Create Journey");
        frame.add(mainPnael);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createJourney objCreate = new createJourney();
    }


}
