package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver.set(new FirefoxDriver(firefoxOptions));
                driver.get().manage().window().maximize();
                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();
                driver.set(new EdgeDriver(edgeOptions));
                driver.get().manage().window().maximize();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }

}




