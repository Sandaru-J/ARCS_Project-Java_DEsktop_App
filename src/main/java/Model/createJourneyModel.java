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
      public int blockID1;
      public int blockID2;
      public int blockID3;
      public int noOfBlocks1;
      public int noOfBlocks2;
      public int noOfBlocks3;

      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (float startingTime) { this.startingTime = startingTime; }
      public void setEndTime (float endTime) { this.endTime = endTime; }
      public void setStartingStation(String startingStation) { this.startingStation = startingStation; }
      public void setDestination (String destination) { this.destination = destination; }
      public void setDate (LocalDate date) { this.date = date; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
      public void setEngineID (int engineID) { this.engineID = engineID; }
      public void setBlockID1 (int blockID1) { this.blockID1 = blockID1; }
      public void setBlockID2 (int blockID2) { this.blockID2 = blockID2; }
      public void setBlockID3 (int blockID3) { this.blockID3 = blockID3; }
      public void setNoOfBlocks1 (int noOfBlocks1) { this.noOfBlocks1 = noOfBlocks1; }
      public void setNoOfBlocks2 (int noOfBlocks2) { this.noOfBlocks2 = noOfBlocks2; }
      public void setNoOfBlocks3 (int noOfBlocks3) { this.noOfBlocks3 = noOfBlocks3; }


      public String getJourneyName() { return journeyName; }
      public float getStartingTime() { return startingTime; }
      public float getEndTime() { return endTime; }
      public String getStartingStation() { return startingStation; }
      public String getDestination() { return destination; }
      public LocalDate getDate() { return date; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
      public int getEngineID() { return engineID; }
      public int getBlockID1() { return blockID1; }
      public int getBlockID2() { return blockID2; }
      public int getBlockID3() { return blockID3; }
      public int getNoOfBlocks1() { return noOfBlocks1; }
      public int getNoOfBlocks2() { return noOfBlocks2; }
      public int getNoOfBlocks3() { return noOfBlocks3; }

}
