package Model;

import java.time.LocalDate;

public class createJourneyModel {

      public String journeyName;
      public float startingTime;
      public float endTime;
      public String startingStation;
      public String destination;
      public LocalDate date;
      public String journeyType;
      public String driverName;
      public int engineID;
      public int blockID;
      public int noOfBlocks;

      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (float startingTime) { this.startingTime = startingTime; }
      public void setEndTime (float endTime) { this.endTime = endTime; }
      public void setStartingStation(String startingStation) { this.startingStation = startingStation; }
      public void setDestination (String destination) { this.destination = destination; }
      public void setDate (LocalDate date) { this.date = date; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
      public void setEngineID (int engineID) { this.engineID = engineID; }
      public void setBlockID (int blockID) { this.blockID = blockID; }
      public void setNoOfBlocks (int noOfBlocks) { this.noOfBlocks = noOfBlocks; }


      public String getJourneyName() { return journeyName; }
      public float getStartingTime() { return startingTime; }
      public float getEndTime() { return endTime; }
      public String getStartingStation() { return startingStation; }
      public String getDestination() { return destination; }
      public LocalDate getDate() { return date; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
      public int getEngineID() { return engineID; }
      public int getBlockID() { return blockID; }
      public int getNoOfBlocks() { return noOfBlocks; }


}
