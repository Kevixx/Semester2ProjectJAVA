package GameApp.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:postgresql://mouse.db.elephantsql.com:5432/lqwkcmia?currentSchema=gaming_application_database", "lqwkcmia", "Xn6mD0fRBFCMXLyPTpcgcD3rNIBcDx11");
    }
}