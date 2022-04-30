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
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {


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
