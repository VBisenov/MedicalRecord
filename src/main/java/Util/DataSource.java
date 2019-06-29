package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static Connection connection;

    private DataSource(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "qwerty");
         properties.setProperty("useUnicode", "true");
           properties.setProperty("characterEncoding", "utf8");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalRecords", properties);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            new DataSource();
        }
        return connection;
    }
}
