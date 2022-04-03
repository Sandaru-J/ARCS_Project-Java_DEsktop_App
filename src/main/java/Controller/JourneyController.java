package Controller;

import Model.createJourneyModel;
import Service.JourneyService;

public class JourneyController {

    JourneyService journeyService = new JourneyService();


    public void createJourney(String journeyName, float startingTime, float endTime, int startingStation, int destination, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, String journeyType, String driverName, int engineID, int blockID, int noOfBlocks) {

        createJourneyModel objcreateJourneyModel = new createJourneyModel();

        objcreateJourneyModel.setJourneyName(journeyName);
        objcreateJourneyModel.setStartingTime(startingTime);
        objcreateJourneyModel.setEndTime(endTime);
        objcreateJourneyModel.setStartingStation(startingStation);
        objcreateJourneyModel.setDestination(destination);
        objcreateJourneyModel.setMonday(monday);
        objcreateJourneyModel.setTuesday(tuesday);
        objcreateJourneyModel.setWednesday(wednesday);
        objcreateJourneyModel.setThursday(thursday);
        objcreateJourneyModel.setFriday(friday);
        objcreateJourneyModel.setSaturday(saturday);
        objcreateJourneyModel.setSunday(sunday);
        objcreateJourneyModel.setJourneyType(journeyType);
        objcreateJourneyModel.setDriverName(driverName);
        objcreateJourneyModel.setEngineID(engineID);
        objcreateJourneyModel.setBlockID(blockID);
        objcreateJourneyModel.setNoOfBlocks(noOfBlocks);

        JourneyService.createJourney(objcreateJourneyModel);


    }
}
