package Controller;

import Model.createJourneyModel;
import Service.JourneyService;

import java.time.LocalDate;

public class JourneyController {

    public void createJourney(String journeyName, float startingTime, float endTime, int startingStation, int destination, LocalDate date, String journeyType, String driverName, int engineID, int blockID, int noOfBlocks) {

        createJourneyModel createJourneyModel = new createJourneyModel();

        createJourneyModel.setJourneyName(journeyName);
        createJourneyModel.setStartingTime(startingTime);
        createJourneyModel.setEndTime(endTime);
        createJourneyModel.setStartingStation(startingStation);
        createJourneyModel.setDestination(destination);
        createJourneyModel.setDate(date);
        createJourneyModel.setJourneyType(journeyType);
        createJourneyModel.setDriverName(driverName);
        createJourneyModel.setEngineID(engineID);
        createJourneyModel.setBlockID(blockID);
        createJourneyModel.setNoOfBlocks(noOfBlocks);

        JourneyService.createJourney(createJourneyModel);
    }

}
