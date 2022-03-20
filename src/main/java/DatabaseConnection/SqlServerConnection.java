package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlServerConnection {
  public Connection createConnectionSqlServer() {
    Connection con = null;
    try {
      //Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;\" +\n" +
              "     \"databaseName=ARCSDatabase" +
              "     \"encrypt=true;trustServerCertificate=true", "Admin", "Admin@12345");
      System.out.println("connect successfully to SqlServer Database ARCSDatabase");

    } catch (Exception e) {
      System.out.println("Connection error to SqlServe Database ARCSDatabase");
      System.err.println(e);
    }
    return con;
  }
}
