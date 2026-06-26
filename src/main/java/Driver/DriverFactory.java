package Driver;

import Enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);



    private DriverFactory() {

    }

    public static void initDriver(String browser) {
        logger.info("Initializing browser: {}", browser);
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());

        switch (browserType){
                        //        switch (browser.toLowerCase()) {
//            case "chrome":
            case CHROME:
                logger.info("Launching Chrome browser....");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case FIREFOX:
                logger.info("Launching Firefox browser....");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver.set(new FirefoxDriver(firefoxOptions));
                driver.get().manage().window().maximize();
                break;

            case EDGE:
                logger.info("Launching Edge browser....");

                EdgeOptions edgeOptions = new EdgeOptions();
                driver.set(new EdgeDriver(edgeOptions));
                driver.get().manage().window().maximize();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            logger.info("Closing Browser");
            driver.remove();
        }
    }

}




