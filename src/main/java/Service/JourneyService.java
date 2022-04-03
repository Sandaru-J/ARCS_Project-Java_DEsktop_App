package Service;

import DatabaseConnection.SqlServerConnection;
import Model.createJourneyModel;
import Model.driverRegisterModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JourneyService {

    public static boolean createJourney(createJourneyModel createJourneyModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();



        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[JourneyDetails] values(?,?,?,?)");
            boolean i;
            {

                ps.setString(1,createJourneyModelObj.getJourneyName());
                ps.setString(2,createJourneyModelObj.getJourneyType());
                ps.setFloat(3,createJourneyModelObj.getStartingTime());
                ps.setFloat(4,createJourneyModelObj.getEndTime());


                i = ps.execute();

                System.out.println("Journey Details Table");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[JourneyDays] values(?,?,?,?,?,?,?)");
            boolean i;
            {

                ps.setBoolean(1,createJourneyModelObj.isMonday());
                ps.setBoolean(2,createJourneyModelObj.isTuesday());
                ps.setBoolean(3,createJourneyModelObj.isWednesday());
                ps.setBoolean(4,createJourneyModelObj.isThursday());
                ps.setBoolean(5,createJourneyModelObj.isFriday());
                ps.setBoolean(6,createJourneyModelObj.isSaturday());
                ps.setBoolean(7,createJourneyModelObj.isSunday());


                i = ps.execute();

                System.out.println("Journey Days Table");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;
    }

}
