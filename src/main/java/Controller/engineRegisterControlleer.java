package Controller;

import Model.engineRegisterModel;
import Service.engineRegisterService;

public class engineRegisterControlleer {

    public void saveEngineReg(String EngineName, float EngineCapacity, String EngineModel)
    {
        engineRegisterModel engineRegisterModel = new engineRegisterModel();

        engineRegisterModel.setEngineName(EngineName);
        engineRegisterModel.setEngineCapacity(EngineCapacity);
        engineRegisterModel.setEngineModel(EngineModel);

        engineRegisterService.saveEngineRegService(engineRegisterModel);
    }

}
