package org.learning.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        FileReader obj = new FileReader("TestData/db.properties");
        Properties properties = new Properties();
        properties.load(obj);
        String username = properties.getProperty("dfas");
        System.out.println(properties.getProperty("usernamee"));
        System.out.println(properties.getProperty("password"));
    }
}
