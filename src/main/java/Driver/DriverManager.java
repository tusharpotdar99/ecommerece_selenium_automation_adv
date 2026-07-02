package Driver;

import Enums.BrowserType;
import utilities.ConfigReader;

import java.time.Duration;

public final class DriverManager {

    private DriverManager(){}

    public static void initDriver(String browser){

        BrowserType browserType =
                BrowserType.valueOf(browser.toUpperCase());

        DriverFactory.setDriver(
                BrowserFactory.createBrowser(browserType)
        );

        DriverFactory.getDriver().manage().deleteAllCookies();

        DriverFactory.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ZERO);

        DriverFactory.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));
    }
}