package Service;
import DatabaseConnection.SqlServerConnection;
//import Model.blockRegisterModel;
import Model.driverRegisterModel;
//import Model.engineRegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {

    public static boolean saveDriverReg(driverRegisterModel dRegModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();
        //driverRegisterModel dRegModelObj = new driverRegisterModel();


        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[DriverDetails] values(?,?,?,?,?,?,?,?)");
            boolean i;
            {

                ps.setString(1, "D01");
                ps.setString(2,dRegModelObj.getDriverFullName());
                ps.setString(3,dRegModelObj.getDriverUserName());
                ps.setInt(4,dRegModelObj.getDriverAge());
                ps.setString(5,dRegModelObj.getDriverNIC());
                ps.setInt(6,dRegModelObj.getDriverContactNumber());
                ps.setString(7,dRegModelObj.getDriverEmail());
                ps.setString(8,dRegModelObj.getDriverPassword());

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
