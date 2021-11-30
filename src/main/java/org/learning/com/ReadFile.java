package org.learning.com;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {

    public String readFile(String value) throws IOException {
        FileReader file = new FileReader("TestData/credentials.properties");
        Properties prop = new Properties();
        prop.load(file);
        return prop.getProperty(value);
    }


    @Test
    public void run() throws IOException {

        ReadFile obj = new ReadFile();
        String username = obj.readFile("username");
        System.out.println(username);

    }
}
