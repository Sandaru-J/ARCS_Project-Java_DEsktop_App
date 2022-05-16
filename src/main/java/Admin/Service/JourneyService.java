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

        int x = 0;
        int y = 0;
        try {
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + start + "';");
            while (rs.next()) {
                x = rs.getInt("Distance");
            }
            //int mielage = rs2.getInt(1)- rs.getInt(1);
            System.out.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + end + "';");


            while (rs2.next()) {
                y = rs2.getInt("Distance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        DecimalFormat df = new DecimalFormat("0.00");

        long distance = y - x;
        float Distance = Float.parseFloat(df.format(distance));

        /////////////////////////////

        Float time1 = cJourney.getStartingTime();
        Float time2 = cJourney.getEndTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH.mm");

        // Parsing the Time Period
        long differenceInHours = 0;
        long differenceInMilliSeconds = 0;
        try {
            Date date1 = (Date) simpleDateFormat.parse(String.valueOf(time1));
            Date date2 = (Date) simpleDateFormat.parse(String.valueOf(time2));


            differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
            differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //float Duration1 = time2-time1;

        System.out.println(time1);
        System.out.println(time2);
        System.out.println(differenceInMilliSeconds);
        System.out.println(differenceInHours);


        final DecimalFormat df1 = new DecimalFormat("0.00");
        float Duration = Float.parseFloat(df1.format(differenceInHours));

        ///////////////////////////

        System.out.println("Duration : " + Duration);
        System.out.println("Distance : " + Distance);

        float AverageSpeed1 = Distance / Duration;

        if (AverageSpeed1 < 0)
            AverageSpeed1 = -AverageSpeed1;

        float AverageSpeed = Float.parseFloat(df1.format(AverageSpeed1));
        System.out.println("Speed : " + AverageSpeed);

        //////////////////////////////

        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertJourneyDetails(?,?,?,?,?,?,?,?,?,?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {
                cs.setString(1, cJourney.getJourneyName());
                cs.setString(2, cJourney.getJourneyType());
                cs.setFloat(3, cJourney.getStartingTime());
                cs.setFloat(4, cJourney.getEndTime());
                cs.setString(5, cJourney.getStartingStation());
                cs.setString(6, cJourney.getDestination());
                cs.setDate(7, Date.valueOf(cJourney.getDate())); //2022-04-25
                cs.setString(8, cJourney.getDriverName());
                cs.setInt(9, cJourney.getTrainID());
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
