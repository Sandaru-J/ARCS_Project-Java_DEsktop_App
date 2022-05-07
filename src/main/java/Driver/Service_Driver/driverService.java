package Driver.Service_Driver;

import DatabaseConnection.SqlServerConnection;
import Driver.Model_Driver.driverSignupModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class driverService {
    public static void driverSignup(driverSignupModel driverSignup) {

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        String qry = "SELECT * FROM ARCSDatabase.dbo.DriverDetails WHERE DriverUserName=? AND DriverPassword=?";

        boolean i;

        try {

            PreparedStatement ps = con.prepareStatement(qry);

            ps.setString(1, driverSignup.getDriverUserName());
            ps.setString(2, driverSignup.getDriverPassword());

            i = ps.execute();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
