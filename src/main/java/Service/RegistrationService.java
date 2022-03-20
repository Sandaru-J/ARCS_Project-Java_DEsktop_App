package Service;
import Model.*;
import DatabaseConnection.SqlServerConnection;
import java.sql.Connection;

public class RegistrationService {
  SqlServerConnection sqlServerConnection = new SqlServerConnection();

  public void saveDriverRegistration() {

    Connection con = sqlServerConnection.createConnectionSqlServer();
    driverRegistrationModel driverRegistrationModel = new driverRegistrationModel();

    //sql code to call a stored procedure

  }
}
