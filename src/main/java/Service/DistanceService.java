package Service;

import DatabaseConnection.SqlServerConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DistanceService {

    public static int distanceGain() throws SQLException {
        String start = "COLOMBO FORT";


        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();
        int x = 1;
        int y = 0;
//DELETE FROM ARCSDatabase.dbo.JourneyDetails WHERE JourneyID='"+UpdatedJourneyID+"';";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + start + "';");


        while (rs.next()) {
            x = rs.getInt("Distance");
        }


        //int mielage = rs2.getInt(1)- rs.getInt(1);

        System.out.println(y+" "+x);

        return 0;
    }
    public static int endDistanceGain() throws SQLException {
        String end = "KANDU";
        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        int y = 0;

        Statement st = con.createStatement();
        ResultSet rs2 = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + end + "';");


        while (rs2.next()) {
            y = rs2.getInt("Distance");
        }
        //int mielage = rs2.getInt(1)- rs.getInt(1);

        System.out.println(y);
        return 1;
    }

    public static void main(String[] args) throws SQLException {
        distanceGain();
        endDistanceGain();
    }
}
