package Controller;
import ControllerInterfaces.IRegistrationController;
import Model.*;
import Service.*;

import java.sql.SQLException;

public class RegistrationController implements IRegistrationController {
  RegistrationService registrationService = new RegistrationService();

  public void saveDriverRegistration(String userName, String Password, String fullName, String age, String nic, String contactNumber, String email) throws SQLException {

    driverRegistrationModel driverRegistrationModel = new driverRegistrationModel();
    driverRegistrationModel.setUserName(userName);
    driverRegistrationModel.setPassword(Password);
    driverRegistrationModel.setFullName(fullName);
    driverRegistrationModel.setAge(age);
    driverRegistrationModel.setNic(nic);
    driverRegistrationModel.setContactNumber(contactNumber);
    driverRegistrationModel.setEmail(email);

    boolean regdriver = registrationService.saveDriverRegistration();

  }
}
