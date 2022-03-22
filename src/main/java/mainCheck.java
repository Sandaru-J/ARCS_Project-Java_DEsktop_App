//import DatabaseConnection.MySqlConnection;
import DatabaseConnection.SqlServerConnection;

public class mainCheck {
  public static void main(String [] args) {

    //Mysql connection
//    MySqlConnection sqlConnection = new MySqlConnection();
//    sqlConnection.createConnectionMySql();

    //sql server connection
    SqlServerConnection sqlServerConnection = new SqlServerConnection();
    sqlServerConnection.createConnectionSqlServer();
  }
}
