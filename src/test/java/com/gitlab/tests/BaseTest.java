package com.gitlab.tests;

import org.testng.annotations.BeforeSuite;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;

public class BaseTest {
    public static Properties prop;
    public static FileInputStream input;
    public static Logger logger;

    @BeforeSuite
    public void setup() {

        try {
            logger = Logger.getLogger("RestAPILog");
            PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/Log4j.properties");
            logger.setLevel(Level.DEBUG);
        } catch (Exception e) {
            e.printStackTrace();
        }

        prop = new Properties();
        try {
            input = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
