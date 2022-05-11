package Admin.Service;

import DatabaseConnection.SqlServerConnection;
import Admin.Model.createJourneyModel;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JourneyService {

    public static boolean createJourney(createJourneyModel cJourney) {

        //////////////////////

        String start = cJourney.getStartingStation();
        String end = cJourney.getDestination();

        SqlServerConnection objSqlServCon = new SqlServerConnection();
        Connection con = objSqlServCon.createConnectionSqlServer();

        int x=0;
        int y=0;
        try {
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + start + "';");
            while (rs.next()) {
                x = rs.getInt("Distance");
            }
            //int mielage = rs2.getInt(1)- rs.getInt(1);
            System.out.println(x);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + end + "';");


            while (rs2.next()) {
                y = rs2.getInt("Distance");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("0.00");

        long distance= y-x;
        float Distance = Float.parseFloat(df.format(distance));

        /////////////////////////////

        float Duration = 0;
        Float time1 = cJourney.getStartingTime();
        Float time2 = cJourney.getEndTime();

        Duration = time2-time1;

        System.out.println("Duration : "+Duration);

        ///////////////////////////

        System.out.println("Duration : "+ Duration);
        System.out.println("Distance : "+ Distance);

        float AverageSpeed = (Distance) / Duration;

        if (AverageSpeed < 0)
            AverageSpeed = -AverageSpeed;

        System.out.println("Speed : "+AverageSpeed);

        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?,?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {
                cs.setString(1,cJourney.getJourneyName());
                cs.setString(2,cJourney.getJourneyType());
                cs.setFloat(3,cJourney.getStartingTime());
                cs.setFloat(4,cJourney.getEndTime());
                cs.setString(5,cJourney.getStartingStation());
                cs.setString(6,cJourney.getDestination());
                cs.setDate(7, Date.valueOf(cJourney.getDate())); //2022-04-25
                cs.setString(8,cJourney.getDriverName());
                cs.setInt(9,cJourney.getTrainID());
                cs.setFloat(10, Distance);
                cs.setFloat(11, Duration);
                cs.setFloat(12, AverageSpeed);

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
