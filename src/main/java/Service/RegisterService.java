package Service;
import DatabaseConnection.SqlServerConnection;
//import Model.blockRegisterModel;
import Model.blockRegisterModel;
import Model.driverRegisterModel;
import Model.engineRegisterModel;
import Model.trainRegisterModel;
import Viewer.dashBoard;
//import Model.engineRegisterModel;
import javax.swing.*;
import java.sql.*;

public class RegisterService {

    public static boolean saveDriverReg(driverRegisterModel dRegModelObj) {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();

        try{
            //String sql="call [ARCSDatabase].[dbo].[InsertDriverDetails] (?,?,?,?,?,?,?,?)";
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertDriverDetails(?,?,?,?,?,?,?)}");

            boolean i;
            {
                cs.setString(1,dRegModelObj.getDriverFullName());
                cs.setString(2,dRegModelObj.getDriverUserName());
                cs.setInt(3,dRegModelObj.getDriverAge());
                cs.setString(4,dRegModelObj.getDriverNIC());
                cs.setInt(5,dRegModelObj.getDriverContactNumber());
                cs.setString(6,dRegModelObj.getDriverEmail());
                cs.setString(7,dRegModelObj.getDriverPassword());

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
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertEngineDetails(?,?,?)}");
//            PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainEngineDetails] values(?,?,?)");
            boolean i;
            {

                cs.setString(1,eRegModelObj.getEngineName());
                cs.setFloat(2,eRegModelObj.getEngineCapacity());
                cs.setString(3,eRegModelObj.getEngineType());


                i = cs.execute();

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
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertBlockDetails(?,?,?,?,?,?,?)}");
            //PreparedStatement ps = con.prepareStatement("insert into [ARCSDatabase].[dbo].[TrainBlockDetails] values(?,?,?,?,?,?,?)");
            boolean i;
            {
                cs.setString(1,bRegModelObj.getBlockName());
                cs.setString(2,bRegModelObj.getBlockModel());
                cs.setString(3,bRegModelObj.getBlockType());
                cs.setFloat(4,bRegModelObj.getBlockLength());
                cs.setFloat(5,bRegModelObj.getBlockWeight());
                cs.setInt(6,bRegModelObj.getBlockCapacity());
                cs.setInt(7,bRegModelObj.getBlockCount());

                i = cs.execute();

                System.out.println("Ok");

            }
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public boolean saveTrainReg(trainRegisterModel tRegModelObj) {

        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();


        try {
            CallableStatement cs = con.prepareCall("{call ARCSDatabase.dbo.InsertTrainDetails(?,?,?,?,?,?,?)}");
            boolean i;
            {
                cs.setInt(1,tRegModelObj.getEngineID());
                cs.setInt(2,tRegModelObj.getBlockID1());
                cs.setInt(3,tRegModelObj.getBlockID2());
                cs.setInt(4,tRegModelObj.getBlockID3());
                cs.setInt(5,tRegModelObj.getNoOfBlocks1());
                cs.setInt(6,tRegModelObj.getNoOfBlocks2());
                cs.setInt(7,tRegModelObj.getNoOfBlocks3());


                i = cs.execute();

                System.out.println("Ok");

            }

            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    }


