package Service;

import DatabaseConnection.SqlServerConnection;
import Model.engineRegisterModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class engineRegisterService {

    public static void saveEngineRegService(engineRegisterModel engineRegisterModel) {
        SqlServerConnection objsqlServerConnection = new SqlServerConnection();
        Connection con = objsqlServerConnection.createConnectionSqlServer();

        //Calling SP
        try{

            PreparedStatement ps = con.prepareStatement("insert into [ARCS].[TrainEngineDetails] values(?,?,?)");

            ps.setString(1, engineRegisterModel.getEngineName());
            ps.setFloat(2, Float.parseFloat(engineRegisterModel.getEngineCapacity()));
            ps.setString(3, engineRegisterModel.getEngineModel());




            System.out.println("Ok");

            int i = ps.executeUpdate();
            System.out.println("Insert: " + i);
            if (i > 0) {
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }


    }
}


