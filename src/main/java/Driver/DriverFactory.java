package Driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private DriverFactory(){}

    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){

        if(driver.get()!=null){

            logger.info("Closing Browser");

            driver.get().quit();

            driver.remove();
        }
    }
}