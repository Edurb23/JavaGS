package fiap.global.solution.infrastructure.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USERNAME = "rm550821";
    private static final String PASSWORD = "fiap23";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME, PASSWORD);
    }
}
