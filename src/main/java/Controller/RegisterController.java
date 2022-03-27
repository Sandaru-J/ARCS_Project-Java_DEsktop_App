package Controller;
import ControllerInterfaces.IRegisterController;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
import Service.RegisterService;


public class RegisterController implements IRegisterController {

    RegisterService registerService = new RegisterService(); //object to RegisterService

    public void saveDriverReg(String DriverRegistrationID, String DriverFullName, String DriverUserName, int DriverAge, String DriverNIC, int DriverContactNumber, String DriverEmail, String DriverPassword) {

        driverRegisterModel objDriverRegisterModel = new driverRegisterModel(); //object to driverRegisterModel

        objDriverRegisterModel.setDriverRegistrationID(DriverRegistrationID);
        objDriverRegisterModel.setDriverFullName(DriverFullName);
        objDriverRegisterModel.setDriverUserName(DriverUserName);
        objDriverRegisterModel.setDriverAge(DriverAge);
        objDriverRegisterModel.setDriverNIC(DriverNIC);
        objDriverRegisterModel.setDriverContactNumber(DriverContactNumber);
        objDriverRegisterModel.setDriverEmail(DriverEmail);
        objDriverRegisterModel.setDriverPassword(DriverPassword);

        registerService.saveDriverReg();
    }

    public void saveEngineReg(String EngineName, float EngineCapacity, String EngineModel) {

        engineRegisterModel engineRegisterModel = new engineRegisterModel(); //object to engineRegisterModel

        engineRegisterModel.setEngineName(EngineName);
        engineRegisterModel.setEngineCapacity(EngineCapacity);
        engineRegisterModel.setEngineModel(EngineModel);

        registerService.saveEngineReg();
    }
}
