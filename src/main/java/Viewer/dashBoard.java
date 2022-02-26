package Viewer;

import javax.swing.*;

public class dashBoard {
    private JPanel dashPanel;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;


    public dashBoard(){
        JFrame frame = new JFrame("Dashboard");
        frame.add(dashPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,600);

    }

    public static void main(String[] args) {
        dashBoard panel = new dashBoard();

    }


}
