package Service;
import DatabaseConnection.SqlServerConnection;
//import Model.blockRegisterModel;
import Model.blockRegisterModel;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
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

    public static boolean saveEngineReg(engineRegisterModel eRegModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {

                ps.setString(1,eRegModelObj.getEngineName());
                ps.setFloat(2,eRegModelObj.getEngineCapacity());
                ps.setString(3,eRegModelObj.getEngineType());


                i = ps.execute();

                System.out.println("Ok");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public static boolean saveBlockReg(blockRegisterModel bRegModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();
        try {

            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainBlockDetails] values(?,?,?,?,?,?,?)");
            boolean i;
            {

                ps.setString(1,bRegModelObj.getBlockModel());
                ps.setString(2,bRegModelObj.getBlockName());
                ps.setString(3,bRegModelObj.getBlockType());
                ps.setFloat(4,bRegModelObj.getBlockLength());
                ps.setFloat(5,bRegModelObj.getBlockWeight());
                ps.setInt(6,bRegModelObj.getBlockCount());
                ps.setInt(7,bRegModelObj.getBlockCapacity());


                i = ps.execute();

                System.out.println("Ok");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}
