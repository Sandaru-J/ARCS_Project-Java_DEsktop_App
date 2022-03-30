package Service;
import DatabaseConnection.SqlServerConnection;
//import Model.blockRegisterModel;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {

    public static boolean saveDriverReg() {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();
        driverRegisterModel driverRegisterModel = new driverRegisterModel();


        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[DriverDetails] values(?,?,?,?,?,?,?)");
            boolean i;

            {

                ps.setString(1, "D01");
                ps.setString(2,driverRegisterModel.getDriverFullName());
                ps.setString(3,driverRegisterModel.getDriverUserName());
                ps.setInt(4,driverRegisterModel.getDriverAge());
                ps.setString(5,driverRegisterModel.getDriverNIC());
                ps.setInt(6,driverRegisterModel.getDriverContactNumber());
                ps.setString(7,driverRegisterModel.getDriverEmail());
                ps.setString(8,driverRegisterModel.getDriverPassword());

                i = ps.execute();

                System.out.println("Ok");

            }
            return i;

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;




    }




//    public static boolean saveBlockReg() {
//        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
//        Connection con = objSqlServerConnection.createConnectionSqlServer();
//        blockRegisterModel blockRegisterModel = new blockRegisterModel();
//
//        return false;
//
//    }
}
