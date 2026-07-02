package Base;

import Driver.DriverFactory;
import Driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        DriverManager.initDriver(ConfigReader.getBrowser());
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getApplicationUrl());

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
