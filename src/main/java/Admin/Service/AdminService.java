package Admin.Service;

import DatabaseConnection.SqlServerConnection;
import Admin.Model.adminSignupModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AdminService {

    public static boolean adminSignup(adminSignupModel admin) {

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        try {
            //PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[AdminDetails] values(?,?,?,?,?,?)");
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertAdminDetails(?,?,?,?,?,?)}");

            cs.setString(1, admin.getAdminFullName());
            cs.setString(2, admin.getAdminUserName());
            cs.setString(3, admin.getAdminNIC());
            cs.setInt(4, admin.getAdminContactNumber());
            cs.setString(5, admin.getAdminEmail());
            cs.setString(6, admin.getAdminPassword());

            cs.execute();

            System.out.println("Ok");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
