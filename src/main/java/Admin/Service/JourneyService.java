package Admin.Service;

import DatabaseConnection.SqlServerConnection;
import Admin.Model.createJourneyModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

public class JourneyService {

    public static boolean createJourney(createJourneyModel cJourney) {



        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {
                cs.setString(1,cJourney.getJourneyName());
                cs.setString(2,cJourney.getJourneyType());
                cs.setTime( 3,cJourney.getStartingTime());
                cs.setTime(4,cJourney.getEndTime());
                cs.setString(5,cJourney.getStartingStation());
                cs.setString(6,cJourney.getDestination());
                cs.setDate(7, Date.valueOf(cJourney.getDate())); //2022-04-25
                cs.setString(8,cJourney.getDriverName());
                cs.setFloat(9,cJourney.getDistance());


                i = cs.execute();

                System.out.println("Ok");
                System.out.println(cJourney.getDistance());

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }


}
