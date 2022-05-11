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


    public void createJourney(String journeyName, Float startingTime, Float endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName, int trainID) throws SQLException, ParseException {

        createJourneyModel createJourneyModel = new createJourneyModel();

        createJourneyModel.setJourneyName(journeyName);
        createJourneyModel.setStartingTime(startingTime);
        createJourneyModel.setEndTime(endTime);
        createJourneyModel.setStartingStation(startingStation);
        createJourneyModel.setDestination(destination);
        createJourneyModel.setDate(date);
        createJourneyModel.setJourneyType(journeyType);
        createJourneyModel.setDriverName(driverName);
        createJourneyModel.setTrainID(trainID);

        JourneyService.createJourney(createJourneyModel);

    }
}
