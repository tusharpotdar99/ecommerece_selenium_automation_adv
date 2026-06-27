package Base;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver(ConfigReader.getBrowser());
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getApplicationUrl());

    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
