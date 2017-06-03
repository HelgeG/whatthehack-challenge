package com.helgegudmundsen.whatthehack.placefinder.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to read properties from project property file.
 */
public class Config {
    private static Properties prop = new Properties();
    private static InputStream input = null;
    static {
        try {
            input = new FileInputStream("properties/placefinder.properties");
            // load a properties file
            prop.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static String getProperty(String property) {
        return prop.getProperty(property);
    }

    public static void main(String[] args) {
        for(String arg : args)
            System.out.println(prop.getProperty(arg));
    }

}