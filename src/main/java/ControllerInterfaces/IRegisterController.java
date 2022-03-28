package ControllerInterfaces;

public interface IRegisterController {

  public default void saveDriverReg(String DriverRegistrationID, String DriverFullName, String DriverUserName, int DriverAge, String DriverNIC, int DriverContactNumber, String DriverEmail, String DriverPassword) {}
  public default  void saveEngineReg(String EngineName, float EngineCapacity, String EngineModel) {}
  public default void saveBlockReg(String BlockModel, String BlockName, String BlockType, float BlockLength, float BlockWeight, int BlockCount, int BlockCapacity) {}

}
