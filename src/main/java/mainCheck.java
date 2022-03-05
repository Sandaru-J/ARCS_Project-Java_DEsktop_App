import DatabaseConenctions.SqlServerConnection;
import DatabaseConenctions.MySqlConnection;

public class mainCheck {

    public static void main(String args[]) {

      //database connection to sql server
      SqlServerConnection SqlConnection = new SqlServerConnection();
      SqlConnection.createConnectionSqlServer();

      //database connection to mysql server
      MySqlConnection mySqlConnection = new MySqlConnection();
      mySqlConnection.createConnectionMySql();
    }
}
