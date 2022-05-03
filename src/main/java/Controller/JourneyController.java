package Controller;

import Model.createJourneyModel;
import Service.JourneyService;

import java.time.LocalDate;

public class JourneyController {

    public void createJourney(String journeyName, float startingTime, float endTime, String startingStation, String destination, LocalDate date, String journeyType, String driverName, int engineID, int blockID1, int blockID2, int blockID3,int noOfBlocks1, int noOfBlocks2, int noOfBlocks3) {

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
        createJourneyModel.setBlockID1(blockID1);
        createJourneyModel.setBlockID2(blockID2);
        createJourneyModel.setBlockID3(blockID3);
        createJourneyModel.setNoOfBlocks1(noOfBlocks1);
        createJourneyModel.setNoOfBlocks2(noOfBlocks2);
        createJourneyModel.setNoOfBlocks3(noOfBlocks3);

        JourneyService.createJourney(createJourneyModel);
    }

}
