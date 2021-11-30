package ir.maktab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private final Connection connection;
    String jdbcURL = "jdbc:mysql://localhost:3306/student";
    String username = "root";
    String password = "Nasim1374";

    public Dao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, username, password);
    }
    public Connection getConnection() {
        return connection;
    }
}
