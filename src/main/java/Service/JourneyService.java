package Service;

import DatabaseConnection.SqlServerConnection;
import Model.createJourneyModel;

import java.sql.CallableStatement;
import java.sql.Connection;

public class JourneyService {

    public static boolean createJourney(createJourneyModel cJourney) {

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?  )}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {

                cs.setString(1,cJourney.getJourneyName());
                cs.setFloat(  2,cJourney.getStartingTime());
                cs.setFloat(3,cJourney.getEndTime());
                cs.setFloat(4,cJourney.getStartingStation());
                cs.setFloat(5,cJourney.getDestination());
                cs.setBoolean(6,cJourney.getMonday());
                cs.setBoolean(7,cJourney.getTuesday());
                cs.setBoolean(8,cJourney.getWednesday());
                cs.setBoolean(9,cJourney.getThursday());
                cs.setBoolean(10,cJourney.getFriday());
                cs.setBoolean(11,cJourney.getSaturday());
                cs.setBoolean(12,cJourney.getSunday());
                cs.setString(13,cJourney.getJourneyType());
                cs.setString(14,cJourney.getDriverName());


                i = cs.execute();

                System.out.println("Ok");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
