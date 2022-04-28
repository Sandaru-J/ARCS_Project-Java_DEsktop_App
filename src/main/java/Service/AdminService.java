package Service;

import DatabaseConnection.SqlServerConnection;
import Model.adminSignupModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminService {

    public static boolean adminSignup(adminSignupModel admin) {

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        try {
            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[AdminDetails] values(?,?,?,?,?,?)");

            ps.setString(1, admin.getAdminFullName());
            ps.setString(2, admin.getAdminUserName());
            ps.setString(3, admin.getAdminNIC());
            ps.setInt(4, admin.getAdminContactNumber());
            ps.setString(5, admin.getAdminEmail());
            ps.setString(6, admin.getAdminPassword());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
