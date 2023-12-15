package com.gitlab.tests;

import com.gitlab.constants.FrameworkContsants;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {
    public static Properties prop;
    public static FileInputStream input;

    @BeforeSuite
    @SneakyThrows
    public void setup() {

        prop = new Properties();
        input = new FileInputStream(FrameworkContsants.PROPERTIES_FILE_PATH);
        prop.load(input);
    }

}
