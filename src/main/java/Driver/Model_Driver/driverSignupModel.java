package Driver.Model_Driver;

public class driverSignupModel {

    public static String driverUserName;
    public String driverPassword;
    public static String JourneyID;

    public void setDriverUsername(String driverUserName) {this.driverUserName = driverUserName;}
    public void setDriverPassword(String driverPassword) {this.driverPassword = driverPassword;}

    public void setJourneyID(String JourneyID){this.JourneyID=JourneyID;}

    public String getDriverUserName() {
        return driverUserName;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public String getJourneyID(){return JourneyID;}
}