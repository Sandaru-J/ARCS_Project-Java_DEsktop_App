package Admin.Controller;

import Admin.Model.createJourneyModel;
import Admin.Service.DistanceService;
import Admin.Service.JourneyService;
import DatabaseConnection.SqlServerConnection;

import java.sql.*;
import java.time.LocalDate;

import static Admin.Service.DistanceService.distanceGain;
import static Admin.Service.DistanceService.endDistanceGain;

public class JourneyController {


    public void createJourney(String journeyName, Time startingTime, Time endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName) throws SQLException {

        createJourneyModel createJourneyModel = new createJourneyModel();



        createJourneyModel.setJourneyName(journeyName);
        createJourneyModel.setStartingTime(startingTime);
        createJourneyModel.setEndTime(endTime);
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
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + start + "';");
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
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery("SELECT Distance FROM ARCSDatabase.dbo.StationDetails WHERE StationName='" + end + "';");


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
