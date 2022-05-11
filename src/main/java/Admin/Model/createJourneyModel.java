package Admin.Model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class createJourneyModel {

      public String journeyName;
      public Float startingTime;
      public Float endTime;
      public String startingStation;
      public String destination;
      public LocalDate date;
      public String journeyType;
      public String driverName;
      public int trainID;


      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (Float startingTime) { this.startingTime = startingTime; }
      public void setEndTime (Float endTime) { this.endTime = endTime; }
      public void setStartingStation(String startingStation) { this.startingStation = startingStation; }
      public void setDestination (String destination) { this.destination = destination; }
      public void setDate (LocalDate date) { this.date = date; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
      public void setTrainID(int trainID) {this.trainID=trainID;}


      public String getJourneyName() { return journeyName; }
      public Float getStartingTime() { return startingTime; }
      public Float getEndTime() { return endTime; }
      public String getStartingStation() { return startingStation; }
      public String getDestination() { return destination; }
      public LocalDate getDate() { return date; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
      public int getTrainID() {return trainID;}


}
