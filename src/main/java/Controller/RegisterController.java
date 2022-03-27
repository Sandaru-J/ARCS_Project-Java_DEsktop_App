package Controller;

import Model.driverRegisterModel;
import Service.driverRegisterService;


public class driverRegisterController {
    driverRegisterService driverregisterService = new driverRegisterService();

    public void saveDriverReg(String DriverRegistrationID, String DriverFullName, String DriverUserName, int DriverAge, String DriverNIC, int DriverContactNumber, String DriverEmail, String DriverPassword)
    {

        driverRegisterModel objDriverRegisterModel = new driverRegisterModel();

        objDriverRegisterModel.setDriverRegistrationID(DriverRegistrationID);
        objDriverRegisterModel.setDriverFullName(DriverFullName);
        objDriverRegisterModel.setDriverUserName(DriverUserName);
        objDriverRegisterModel.setDriverAge(DriverAge);
        objDriverRegisterModel.setDriverNIC(DriverNIC);
        objDriverRegisterModel.setDriverContactNumber(DriverContactNumber);
        objDriverRegisterModel.setDriverEmail(DriverEmail);
        objDriverRegisterModel.setDriverPassword(DriverPassword);

        //driverregisterService.saveDriverReg();
    }
}
