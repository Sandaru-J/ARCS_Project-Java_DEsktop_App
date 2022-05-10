package Admin.Service;

import DatabaseConnection.SqlServerConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DistanceService {

    public static int distanceGain(String startingStation) throws SQLException {
        String start = startingStation;


        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();
        int x=0;

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + start + "';");


        while (rs.next()) {
            x = rs.getInt("Distance");
        }


        //int mielage = rs2.getInt(1)- rs.getInt(1);

        System.out.println(x);

        return x;
    }
    public static int endDistanceGain(String destination) throws SQLException {
        String end = destination;
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
        return y;
    }

}
