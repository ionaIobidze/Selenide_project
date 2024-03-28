package ge.tbcitacademy.steps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfigLoader.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
