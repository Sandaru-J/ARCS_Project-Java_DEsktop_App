package Service;

import DatabaseConnection.SqlServerConnection;
import Model.engineRegisterModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class engineRegisterService {

    public static boolean saveEngineReg() {
        SqlServerConnection objsqlServerConnection = new SqlServerConnection();
        Connection con = objsqlServerConnection.createConnectionSqlServer();
        engineRegisterModel engineRegisterModel = new engineRegisterModel();

        //Calling SP
        try{

            PreparedStatement ps = con.prepareStatement("insert into [ARCS].[TrainEngineDetails] values('a','b','c',1,'e',2,'g','h')");


//            ps.setString(1, "userName");
//            ps.setString(2, "password");
//            ps.setString(3, "fullName");
//            ps.setInt(4, 1);
//            ps.setString(5, "nic");
//            ps.setInt(6, 2);
//            ps.setString(7, "email");
//            ps.setString(8, "email1");

            System.out.println("Ok");

            int i = ps.executeUpdate();
            System.out.println("Insert: " + i);
            if (i > 0)
                return true;
            else
                return false;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }


        return false;
    }

    public static void main(String [] args) throws SQLException
    {
        boolean saveEngineReg = saveEngineReg();

    }

}


