package org.example.apiutils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static String getProperty(String key) {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(fis);
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }

        String value = prop.getProperty(key);
        return value;
    }
}