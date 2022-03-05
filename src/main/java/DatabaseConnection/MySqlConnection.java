package DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
  public void createConnectionMySql() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "mmw@sql");
      System.out.println("connect successfully to MySql Database");

    } catch (Exception e) {
      System.out.println("Connection error to MySql Database");
      System.err.println(e);
    }
  }
}
