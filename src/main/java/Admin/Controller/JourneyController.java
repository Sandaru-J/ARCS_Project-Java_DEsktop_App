package Admin.Controller;

import Admin.Model.createJourneyModel;
import Admin.Service.JourneyService;

import java.time.LocalDate;

public class JourneyController {

    public void createJourney(String journeyName, float startingTime, float endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName) {

        createJourneyModel createJourneyModel = new createJourneyModel();

        createJourneyModel.setJourneyName(journeyName);
        createJourneyModel.setStartingTime(startingTime);
        createJourneyModel.setEndTime(endTime);
        createJourneyModel.setStartingStation(startingStation);
        createJourneyModel.setDestination(destination);
        createJourneyModel.setDate(date);
        createJourneyModel.setJourneyType(journeyType);
        createJourneyModel.setDriverName(driverName);


        JourneyService.createJourney(createJourneyModel);
    }

}
