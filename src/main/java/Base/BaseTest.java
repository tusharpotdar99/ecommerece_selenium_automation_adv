package Base;

import Driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver(ConfigReader.getBrowser());
        DriverFactory.getDriver().get(ConfigReader.getApplicationUrl());

    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
