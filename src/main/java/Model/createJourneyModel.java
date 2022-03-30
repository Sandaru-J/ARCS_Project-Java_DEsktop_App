package Model;

public class createJourneyModel {

      public String journeyName;
      public float startingTime;
      public float endTime;
      public int startingStation;
      public int destination;
      public int monday;
      public int tuesday;
      public int wednesday;
      public int thursday;
      public int friday;
      public int saturday;
      public int sunday;
      public String journeyType;
      public String driverName;
      public int engineID;
      public int blockID;
      public int noOfBlocks;

      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (float startingTime) { this.startingTime = startingTime; }
      public void setEndTime (float endTime) { this.endTime = endTime; }
      public void setStartingStation (int startingStation) { this.startingStation = startingStation; }
      public void setDestination (int destination) { this.destination = destination; }
      public void setMonday (int monday) { this.monday = monday; }
      public void setTuesday (int tuesday) { this.tuesday = tuesday; }
      public void setWednesday (int wednesday) { this.wednesday = wednesday; }
      public void setThursday (int thursday) { this.thursday = thursday; }
      public void setFriday (int friday) { this.friday = friday; }
      public void setSaturday (int saturday) { this.saturday = saturday; }
      public void setSunday (int sunday) { this.sunday = sunday; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
      public void setEngineID (int engineID) { this.engineID = engineID; }
      public void setJourneyName (int blockID) { this.blockID = blockID; }
      public void setNoOfBlocks (int noOfBlocks) { this.noOfBlocks = noOfBlocks; }

      public String getJourneyName() { return journeyName; }
      public float getStartingTime() { return startingTime; }
      public float getEndTime() { return endTime; }
      public int getStartingStation() { return startingStation; }
      public int getDestination() { return destination; }
      public int getMonday() { return monday; }
      public int getTuesday() { return tuesday; }
      public int getWednesday() { return wednesday; }
      public int getThursday() { return thursday; }
      public int getFriday() { return friday; }
      public int getSaturday() { return saturday; }
      public int getSunday() { return sunday; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
      public int getEngineID() { return engineID; }
      public int getBlockID() { return blockID; }
      public int getNoOfBlocks() { return noOfBlocks; }
}
