package Service;
import DatabaseConnection.SqlServerConnection;
//import Model.blockRegisterModel;
import Model.blockRegisterModel;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
//import Model.engineRegisterModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {

    public static boolean saveDriverReg(driverRegisterModel dRegModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();
        //driverRegisterModel dRegModelObj = new driverRegisterModel();


        //        try {
//
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[DriverDetails] values(?,?,?,?,?,?,?,?)");
//            boolean i;
//            {
//
//                ps.setString(1, "D01");
//                ps.setString(2,dRegModelObj.getDriverFullName());
//                ps.setString(3,dRegModelObj.getDriverUserName());
//                ps.setInt(4,dRegModelObj.getDriverAge());
//                ps.setString(5,dRegModelObj.getDriverNIC());
//                ps.setInt(6,dRegModelObj.getDriverContactNumber());
//                ps.setString(7,dRegModelObj.getDriverEmail());
//                ps.setString(8,dRegModelObj.getDriverPassword());
//
//                i = ps.execute();
//
//                System.out.println("Ok");
//
//            }
//            return i;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        try{
            //String sql="call [ARCSDatabase].[dbo].[InsertDriverDetails] (?,?,?,?,?,?,?,?)";
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertDriverDetails(?,?,?,?,?,?,?,?)}");

            boolean i;
            {
                cs.setString(1, "D01");
                cs.setString(2,dRegModelObj.getDriverFullName());
                cs.setString(3,dRegModelObj.getDriverUserName());
                cs.setInt(4,dRegModelObj.getDriverAge());
                cs.setString(5,dRegModelObj.getDriverNIC());
                cs.setInt(6,dRegModelObj.getDriverContactNumber());
                cs.setString(7,dRegModelObj.getDriverEmail());
                cs.setString(8,dRegModelObj.getDriverPassword());

                i = cs.execute();

                System.out.println("OK");

            }

            return i;


        } catch (SQLException e) {
            e.printStackTrace();
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
                ps.setString(2,bRegModelObj.getBlockType());
                ps.setFloat(3,bRegModelObj.getBlockLength());
                ps.setFloat(4,bRegModelObj.getBlockWeight());
                ps.setInt(5,bRegModelObj.getBlockCapacity());
                ps.setInt(6,bRegModelObj.getBlockCount());
                ps.setInt(7,0);

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
