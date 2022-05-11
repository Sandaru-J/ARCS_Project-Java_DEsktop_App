package Admin.Controller;

import Admin.Model.createJourneyModel;
import Admin.Service.JourneyService;

import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;

public class JourneyController {


    public boolean createJourney(String journeyName, Float startingTime, Float endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName, int trainID) throws SQLException, ParseException {

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

        return false;
    }
}
