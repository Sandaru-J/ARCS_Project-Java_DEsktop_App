package Controller;

import Model.createJourneyModel;
import Service.JourneyService;

public class JourneyController {

    public void createJourney(String journeyName, float startingTime, float endTime, int startingStation, int destination, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, String journeyType, String driverName) {

        createJourneyModel createJourneyModel = new createJourneyModel();

        createJourneyModel.setJourneyName(journeyName);
        createJourneyModel.setStartingTime(startingTime);
        createJourneyModel.setEndTime(endTime);
        createJourneyModel.setStartingTime(startingStation);
        createJourneyModel.setDestination(destination);
        createJourneyModel.setMonday(monday);
        createJourneyModel.setTuesday(tuesday);
        createJourneyModel.setWednesday(wednesday);
        createJourneyModel.setThursday(thursday);
        createJourneyModel.setFriday(friday);
        createJourneyModel.setSaturday(saturday);
        createJourneyModel.setSunday(sunday);
        createJourneyModel.setJourneyType(journeyType);
        createJourneyModel.setDriverName(driverName);

        JourneyService.createJourney(createJourneyModel);
    }

}
