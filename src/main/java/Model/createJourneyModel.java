package Model;

public class createJourneyModel {

      public String journeyName;
      public float startingTime;
      public float endTime;
      public int startingStation;
      public int destination;
      public boolean monday;
      public boolean tuesday;
      public boolean wednesday;
      public boolean thursday;
      public boolean friday;
      public boolean saturday;
      public boolean sunday;
      public String journeyType;
      public String driverName;
//      public int engineID;
//      public int blockID;
//      public int noOfBlocks;

      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (float startingTime) { this.startingTime = startingTime; }
      public void setEndTime (float endTime) { this.endTime = endTime; }
      public void setStartingStation (int startingStation) { this.startingStation = startingStation; }
      public void setDestination (int destination) { this.destination = destination; }
      public void setMonday (boolean monday) { this.monday = monday; }
      public void setTuesday (boolean tuesday) { this.tuesday = tuesday; }
      public void setWednesday (boolean wednesday) { this.wednesday = wednesday; }
      public void setThursday (boolean thursday) { this.thursday = thursday; }
      public void setFriday (boolean friday) { this.friday = friday; }
      public void setSaturday (boolean saturday) { this.saturday = saturday; }
      public void setSunday (boolean sunday) { this.sunday = sunday; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
//      public void setEngineID (int engineID) { this.engineID = engineID; }
//      public void setJourneyName (int blockID) { this.blockID = blockID; }
//      public void setNoOfBlocks (int noOfBlocks) { this.noOfBlocks = noOfBlocks; }

      public String getJourneyName() { return journeyName; }
      public float getStartingTime() { return startingTime; }
      public float getEndTime() { return endTime; }
      public int getStartingStation() { return startingStation; }
      public int getDestination() { return destination; }
      public boolean getMonday() { return monday; }
      public boolean getTuesday() { return tuesday; }
      public boolean getWednesday() { return wednesday; }
      public boolean getThursday() { return thursday; }
      public boolean getFriday() { return friday; }
      public boolean getSaturday() { return saturday; }
      public boolean getSunday() { return sunday; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
//      public int getEngineID() { return engineID; }
//      public int getBlockID() { return blockID; }
//      public int getNoOfBlocks() { return noOfBlocks; }
}
