package Model;

public class driverRegisterModel {

    public String driverRegistrationID;
    public String driverFullName;
    public String driverUserName;
    public int driverAge;
    public String driverNIC;
    public int driverContactNumber;
    public String driverEmail;
    public String driverPassword;

    //public void setDriverRegistrationID(String driverRegistrationID) { this.driverRegistrationID = driverRegistrationID;}
    public void setDriverFullName(String driverFullName) { this.driverFullName = driverFullName;
    System.out.println(driverFullName);}
    public void setDriverUserName(String driverUserName) { this.driverUserName = driverUserName; }
    public void setDriverAge(int driverAge) { this.driverAge = driverAge; }
    public void setDriverNIC(String driverNIC) {this.driverNIC = driverNIC; }
    public void setDriverContactNumber(int driverContactNumber) { this. driverContactNumber = driverContactNumber; }
    public void setDriverEmail(String driverEmail) { this.driverEmail = driverEmail; }
    public void setDriverPassword(String driverPassword) { this.driverPassword = driverPassword; }

    //public String getDriverRegistrationID() { return driverRegistrationID; }

//    public String getDriverFullName() { return driverFullName; }
//    public String getDriverUserName() { return  driverUserName; }
//    public int getDriverAge() { return driverAge; }
//    public String getDriverNIC() { return driverNIC; }
//    public int getDriverContactNumber() { return driverContactNumber; }
//    public String getDriverEmail() { return driverEmail; }
//    public String getDriverPassword() { return driverPassword; }

    public String getDriverFullName(){return driverFullName;}
    public String getDriverUserName(){return driverUserName;}
    public int getDriverAge(){return driverAge; }
    public String getDriverNIC(){return driverNIC; }
    public int getDriverContactNumber(){return driverContactNumber; }
    public String getDriverEmail(){return driverEmail; }
    public String getDriverPassword(){return driverPassword; }


}
