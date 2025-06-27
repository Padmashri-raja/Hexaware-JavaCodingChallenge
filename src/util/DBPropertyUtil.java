package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getPropertyString(String fileName) {
        Properties props = new Properties();
        String connectionString = null;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
            String hostname = props.getProperty("hostname");
            String port = props.getProperty("port");
            String dbname = props.getProperty("dbname");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            connectionString = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname +
                               "?user=" + username + "&password=" + password;
        } catch (IOException e) {
            System.out.println("Error reading DB properties: " + e.getMessage());
        }

        return connectionString;
    }
}
