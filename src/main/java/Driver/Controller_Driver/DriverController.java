package Driver.Controller_Driver;

import Driver.Model_Driver.driverSignupModel;
import Driver.Service_Driver.driverService;
import Driver.Viewer_Driver.driverDashboard;

public class DriverController {
    public boolean driverLogin(String driverUserName, String driverPassword) {

        driverSignupModel driverSignupModel = new driverSignupModel();

        driverSignupModel.setDriverUsername(driverUserName);
        driverSignupModel.setDriverPassword(driverPassword);

        driverService.driverSignup(driverSignupModel);
        //driverDashboard.viewDriverJourney(driverSignupModel);
        return false;
    }
}
