package ControllerInterfaces;

public interface IRegistrationController {
  public default void SaveDriverRegistration(String userName, String Password, String fullName, int age, String nic, int contactNumber, String email) {}
}
