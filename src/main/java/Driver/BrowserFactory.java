package Driver;

import Enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ConfigReader;

public final class BrowserFactory {

    private BrowserFactory() {}

    public static WebDriver createBrowser(BrowserType browserType) {

        switch (browserType) {

            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();

                if (ConfigReader.isHeadless()) {
                    chromeOptions.addArguments("--headless=new");
                }

                chromeOptions.addArguments(
                        "--window-size=1920,1080",
                        "--start-maximized",
                        "--disable-gpu",
                        "--no-sandbox",
                        "--disable-dev-shm-usage"
                );

                return new ChromeDriver(chromeOptions);

            case FIREFOX:

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (ConfigReader.isHeadless()) {
                    firefoxOptions.addArguments("-headless");
                }

                return new FirefoxDriver(firefoxOptions);

            case EDGE:

                EdgeOptions edgeOptions = new EdgeOptions();

                if (ConfigReader.isHeadless()) {
                    edgeOptions.addArguments("--headless=new");
                }

                return new EdgeDriver(edgeOptions);

            default:
                throw new IllegalArgumentException("Unsupported Browser : " + browserType);
        }
    }
}