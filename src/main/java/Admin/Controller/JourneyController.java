package Admin.Controller;

import Admin.Model.createJourneyModel;
import Admin.Service.JourneyService;
import DatabaseConnection.SqlServerConnection;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JourneyController {


    public void createJourney(String journeyName, String startingTime, String endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName) throws SQLException, ParseException {

        createJourneyModel createJourneyModel = new createJourneyModel();

        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        LocalDateTime st = LocalDateTime.parse(startingTime);
//        Date st = dateFormat.parse(startingTime);
        Time et = (Time) dateFormat.parse(endTime);

        createJourneyModel.setJourneyName(journeyName);
        //createJourneyModel.setStartingTime(st);
        createJourneyModel.setEndTime(et);
        createJourneyModel.setStartingStation(startingStation);
        createJourneyModel.setDestination(destination);
        createJourneyModel.setDate(date);
        createJourneyModel.setJourneyType(journeyType);
        createJourneyModel.setDriverName(driverName);

//        DistanceService distanceService = new DistanceService();
//        distanceService.distanceGain(startingStation);
//        distanceService.endDistanceGain(destination);

        String start = startingStation;
        String end = destination;

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

        long distance=y-x;
        System.out.println(distance);

        createJourneyModel.setDistance(distance);

        JourneyService.createJourney(createJourneyModel);

    }
}
