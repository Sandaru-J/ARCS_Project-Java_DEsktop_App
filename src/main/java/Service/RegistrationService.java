package Service;
import Model.*;
import DatabaseConnection.SqlServerConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationService {


  public static boolean saveDriverRegistration() throws SQLException {

    SqlServerConnection sqlServerConnection = new SqlServerConnection();
    Connection con = sqlServerConnection.createConnectionSqlServer();
    driverRegistrationModel driverRegistrationModel = new driverRegistrationModel();

    //sql code to call a stored procedure
//    try{
//
//      int i;
//      try (PreparedStatement ps = con.prepareStatement("insert into DriverDetails values(?,?,?,?,?,?,?,?)")) {
//
//
//        ps.setString(1, "userName");
//        ps.setString(2, "password");
//        ps.setString(3, "fullName");
//        ps.setInt(4, 1);
//        ps.setString(5, "nic");
//        ps.setInt(6, 2);
//        ps.setString(7, "email");
//        ps.setString(8, "email1");
//
//        System.out.println("Ok");
//
//        i = ps.executeUpdate();
//      }
//      System.out.println("Insert: " + i);
//      if (i > 0)
//        return true;
//      else
//        return false;
//
//    }
//    catch(Exception ex)
//    {
//      ex.printStackTrace();
//    }

    PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[DriverDetails] values(?,?,?,?,?,?,?,?)");
    boolean status;
    {


      ps.setString(1, "id");
      ps.setString(2, "RegId");
      ps.setString(3, "fullName");
      ps.setInt(4, 123544);
      ps.setString(5, "age");
      ps.setInt(6, 4564);
      ps.setString(7, "cNo");
      ps.setString(8, "email");

      status = ps.execute();

    }
    return status;
  }
    public static void main(String[] args) throws SQLException {
     saveDriverRegistration();

    }



}
