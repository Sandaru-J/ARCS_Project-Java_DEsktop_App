package Controller;
import ControllerInterfaces.IRegisterController;
//import Model.blockRegisterModel;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
import Service.RegisterService;


public class RegisterController implements IRegisterController {

    RegisterService registerService = new RegisterService(); //object to RegisterService

    public void saveDriverReg(String DriverFullName, String DriverUserName, int DriverAge, String DriverNIC, int DriverContactNumber, String DriverEmail, String DriverPassword) {

        driverRegisterModel objDriverRegisterModel = new driverRegisterModel(); //object to driverRegisterModel

        //objDriverRegisterModel.setDriverRegistrationID(DriverRegistrationID);
        objDriverRegisterModel.setDriverFullName(DriverFullName);
        objDriverRegisterModel.setDriverUserName(DriverUserName);
        objDriverRegisterModel.setDriverAge(DriverAge);
        objDriverRegisterModel.setDriverNIC(DriverNIC);
        objDriverRegisterModel.setDriverContactNumber(DriverContactNumber);
        objDriverRegisterModel.setDriverEmail(DriverEmail);
        objDriverRegisterModel.setDriverPassword(DriverPassword);

        registerService.saveDriverReg();
    }

//    public void saveEngineReg(String EngineName, float EngineCapacity, String EngineType) {
//
//        engineRegisterModel engineRegisterModel = new engineRegisterModel(); //object to engineRegisterModel
//
//        engineRegisterModel.setEngineName(EngineName);
//        engineRegisterModel.setEngineCapacity(EngineCapacity);
//        engineRegisterModel.setEngineType(EngineType);
//
//        registerService.saveEngineReg();
//    }

//    public void saveBlockReg(String BlockModel, String BlockName, String BlockType, float BlockLength, float BlockWeight, int BlockCount, int BlockCapacity) {
//
//        blockRegisterModel blockRegisterModel = new blockRegisterModel(); //object to blockRegisterModel
//
//        blockRegisterModel.setBlockModel(BlockModel);
//        blockRegisterModel.setBlockName(BlockName);
//        blockRegisterModel.setBlockType(BlockType);
//        blockRegisterModel.setBlockLength(BlockLength);
//        blockRegisterModel.setBlockWeight(BlockWeight);
//        blockRegisterModel.setBlockCount(BlockCount);
//        blockRegisterModel.setBlockCapacity(BlockCapacity);
//
//        registerService.saveBlockReg();
//    }
}
