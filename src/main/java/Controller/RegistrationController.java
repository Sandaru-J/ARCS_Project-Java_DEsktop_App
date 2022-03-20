package Controller;
import ControllerInterfaces.IRegistrationController;
import Model.*;
import Service.*;

public class RegistrationController implements IRegistrationController {
  RegistrationService registrationService = new RegistrationService();

  public void saveDriverRegistration(String userName, String Password, String fullName, int age, String nic, int contactNumber, String email) {

    driverRegistrationModel driverRegistrationModel = new driverRegistrationModel();
    driverRegistrationModel.setUserName(userName);
    driverRegistrationModel.setPassword(Password);
    driverRegistrationModel.setFullName(fullName);
    driverRegistrationModel.setAge(age);
    driverRegistrationModel.setNic(nic);
    driverRegistrationModel.setContactNumber(contactNumber);
    driverRegistrationModel.setEmail(email);

    registrationService.saveDriverRegistration();

  }
}
