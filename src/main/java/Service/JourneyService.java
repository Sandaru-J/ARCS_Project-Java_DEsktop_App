package Service;

import DatabaseConnection.SqlServerConnection;
import Model.createJourneyModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

public class JourneyService {

    public static boolean createJourney(createJourneyModel cJourney) {



        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {
                cs.setString(1,cJourney.getJourneyName());
                cs.setString(2,cJourney.getJourneyType());
                cs.setFloat( 3,cJourney.getStartingTime());
                cs.setFloat(4,cJourney.getEndTime());
                cs.setString(5,cJourney.getStartingStation());
                cs.setString(6,cJourney.getDestination());
                cs.setDate(7, Date.valueOf(cJourney.getDate())); //2022-04-25
                cs.setString(8,cJourney.getDriverName());
                cs.setInt(9,cJourney.getEngineID());
                cs.setInt(10,cJourney.getBlockID1());
                cs.setInt(11,cJourney.getBlockID2());
                cs.setInt(12,cJourney.getBlockID3());
                cs.setInt(13,cJourney.getNoOfBlocks1());
                cs.setInt(14,cJourney.getNoOfBlocks2());
                cs.setInt(15,cJourney.getNoOfBlocks3());


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
