package Admin.Model;

import java.sql.Time;
import java.time.LocalDate;

public class createJourneyModel {

      public String journeyName;
      public Time startingTime;
      public Time endTime;
      public String startingStation;
      public String destination;
      public LocalDate date;
      public String journeyType;
      public String driverName;
      public float distance;

      public void setJourneyName (String journeyName) { this.journeyName = journeyName; }
      public void setStartingTime (Time startingTime) { this.startingTime = startingTime; }
      public void setEndTime (Time endTime) { this.endTime = endTime; }
      public void setStartingStation(String startingStation) { this.startingStation = startingStation; }
      public void setDestination (String destination) { this.destination = destination; }
      public void setDate (LocalDate date) { this.date = date; }
      public void setJourneyType (String journeyType) { this.journeyType = journeyType; }
      public void setDriverName (String driverName) { this.driverName = driverName; }
      public void setDistance(float distance) {this.distance=distance;}


      public String getJourneyName() { return journeyName; }
      public Time getStartingTime() { return startingTime; }
      public Time getEndTime() { return endTime; }
      public String getStartingStation() { return startingStation; }
      public String getDestination() { return destination; }
      public LocalDate getDate() { return date; }
      public String getJourneyType() { return journeyType; }
      public String getDriverName() { return driverName; }
      public float getDistance() {return distance;}


}
