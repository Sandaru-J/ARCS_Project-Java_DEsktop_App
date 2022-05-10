package Driver.Viewer_Driver;

import DatabaseConnection.SqlServerConnection;
import Driver.Model_Driver.driverSignupModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class driverAssignedJourneys {

    public String JourneyID;
    private JTable tblDriverAssignedJourneys;
    private JPanel panelDriverAssignedJourneys;

    public driverAssignedJourneys()
    {
        JFrame frame = new JFrame("");
        //frame.setUndecorated(true);
        frame.add(panelDriverAssignedJourneys);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(1200, 600);
        viewDriverAssignedJourneysTbl();


        tblDriverAssignedJourneys.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel tableModel = (DefaultTableModel)tblDriverAssignedJourneys.getModel();

                JourneyID = (String) tableModel.getValueAt(tblDriverAssignedJourneys.getSelectedRow(),1);
                driverSignupModel dsm = new driverSignupModel();
                dsm.setJourneyID(JourneyID);
                System.out.println("check jID from  driver Tabel = "+JourneyID);
                new driverDashboard();

            }
        });
    }



    public int rowCountDriverAssignedJourneys() {
        int count = 0;
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        try {
            Statement rst = con.createStatement();
            ResultSet rsRow = rst.executeQuery("SELECT COUNT(driverUserName) FROM [ARCSDatabase].[dbo].[DriverDetails]");
            rsRow.next();
            count = rsRow.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private void viewDriverAssignedJourneysTbl() {
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        driverSignupModel dsm = new driverSignupModel();
        String driverUserName = dsm.getDriverUserName();

        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.ViewJourneyByDriverName('"+driverUserName+"')}");
            ResultSet rs = cs.executeQuery();

            int RowCount = rowCountDriverAssignedJourneys();

            String columns[] = {"Journey Name", "Journey ID", "Start Time", "End Time", "Start Station", "End Station"};
            String data[][] = new String[RowCount][6];

            int i = 0;
            while (rs.next()) {
                String JourneyName = rs.getString("JourneyName");
                int JourneyID = rs.getInt("JourneyID");
                String JourneyStartTime = rs.getString("JourneyStartTime");
                String JourneyEndTime = rs.getString("JourneyEndTime");
                String StartStationName = rs.getString("StartStationName");
                String EndStationName = rs.getString("EndStationName");

                data[i][0] = JourneyName;
                data[i][1] = JourneyID + "";
                data[i][2] = JourneyStartTime;
                data[i][3] = JourneyEndTime;
                data[i][4] = StartStationName ;
                data[i][5] = EndStationName;
                i++;
            }
            tblDriverAssignedJourneys.setModel(new DefaultTableModel
                    (data, columns
                    ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ///new driverAssignedJourneys();
    }
}