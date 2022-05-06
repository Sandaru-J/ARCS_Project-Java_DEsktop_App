package Service;

import DatabaseConnection.SqlServerConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DistanceService {

    public int distanceGain() throws SQLException {
        String start = "FORT";
        String end = "KANDY";

        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

//DELETE FROM ARCSDatabase.dbo.JourneyDetails WHERE JourneyID='"+UpdatedJourneyID+"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='"+start+"';");
            ResultSet rs2 = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='"+end+"';");

            int mielage = rs2.getInt(1)- rs.getInt(1);

            System.out.println(mielage);

        return mielage;
    }
}
