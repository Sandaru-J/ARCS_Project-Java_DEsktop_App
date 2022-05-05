package Controller;
//import ControllerInterfaces.IRegisterController;
//import Model.blockRegisterModel;
import Model.blockRegisterModel;
import Model.driverRegisterModel;
//import Model.engineRegisterModel;
import Model.engineRegisterModel;
import Model.trainRegisterModel;
import Service.RegisterService;


public class RegisterController {

    RegisterService registerService = new RegisterService(); //object to RegisterService

    public boolean saveDriverReg(String DriverFullName, String DriverUserName, int DriverAge, String DriverNIC, int DriverContactNumber, String DriverEmail, String DriverPassword) {

        driverRegisterModel objDriverRegisterModel = new driverRegisterModel(); //object to driverRegisterModel

        //objDriverRegisterModel.setDriverRegistrationID(DriverRegistrationID);
        objDriverRegisterModel.setDriverFullName(DriverFullName);
        objDriverRegisterModel.setDriverUserName(DriverUserName);
        objDriverRegisterModel.setDriverAge(DriverAge);
        objDriverRegisterModel.setDriverNIC(DriverNIC);
        objDriverRegisterModel.setDriverContactNumber(DriverContactNumber);
        objDriverRegisterModel.setDriverEmail(DriverEmail);
        objDriverRegisterModel.setDriverPassword(DriverPassword);

        boolean i=registerService.saveDriverReg(objDriverRegisterModel);
        return i;
    }

    public boolean saveEngineReg(String EngineName, float EngineCapacity, String EngineType) {

        engineRegisterModel engineRegisterModel = new engineRegisterModel(); //object to engineRegisterModel

        engineRegisterModel.setEngineName(EngineName);
        engineRegisterModel.setEngineCapacity(EngineCapacity);
        engineRegisterModel.setEngineType(EngineType);

        registerService.saveEngineReg(engineRegisterModel);
        return false;
    }

    public boolean saveBlockReg(String BlockModel, String BlockName, String BlockType, float BlockLength, float BlockWeight, int BlockCount, int BlockCapacity) {

        System.out.println("came to controller");
        blockRegisterModel blockRegisterModel = new blockRegisterModel(); //object to blockRegisterModel

        blockRegisterModel.setBlockModel(BlockModel);
        blockRegisterModel.setBlockName(BlockName);
        blockRegisterModel.setBlockType(BlockType);
        blockRegisterModel.setBlockLength(BlockLength);
        blockRegisterModel.setBlockWeight(BlockWeight);
        blockRegisterModel.setBlockCount(BlockCount);
        blockRegisterModel.setBlockCapacity(BlockCapacity);

        registerService.saveBlockReg(blockRegisterModel);
        return false;
    }

    public boolean saveTrainReg(int engineID, int blockID1, int blockID2, int blockID3, int noOfBlocks1, int noOfBlocks2, int noOfBlocks3) {

        trainRegisterModel trainRegisterModel = new trainRegisterModel();

        trainRegisterModel.setEngineID(engineID);
        trainRegisterModel.setBlockID1(blockID1);
        trainRegisterModel.setBlockID2(blockID2);
        trainRegisterModel.setBlockID3(blockID3);
        trainRegisterModel.setNoOfBlocks1(noOfBlocks1);
        trainRegisterModel.setNoOfBlocks2(noOfBlocks2);
        trainRegisterModel.setNoOfBlocks3(noOfBlocks3);

        registerService.saveTrainReg(trainRegisterModel);

        return false;
    }
}
