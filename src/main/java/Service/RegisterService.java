package Service;
import DatabaseConnection.SqlServerConnection;
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

        return false;
    }

    public static boolean saveEngineReg() {
        SqlServerConnection objSqlServerConnection = new SqlServerConnection();
        Connection con = objSqlServerConnection.createConnectionSqlServer();
        engineRegisterModel engineRegisterModel = new engineRegisterModel();

        return false;
    }
}
