import java.sql.*;

public class databaseCheck {

    public static void main(String args[]) {

      try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","mmw@sql");
        System.out.println("connect successfully");

      } catch(Exception e) {
        System.out.println("Connection error");
        System.err.println(e);
      }
    }
  }
