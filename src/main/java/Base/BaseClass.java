package Base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

//    public String url = "https://tutorialsninja.com/demo/";
    public WebDriver driver;
    public Logger logger;
    public Properties properties;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(@Optional("windows") String os,
                      @Optional("chrome") String browser) throws IOException {


        FileReader file = new FileReader("./src/main/resources/config_properties");
        properties = new Properties();
        properties.load(file);


        logger= LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver();break;
            case "edge": driver = new EdgeDriver();break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser name ...."); return;

        }

//        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));

        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber(){
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric(){
        String generatedstring = RandomStringUtils.randomAlphabetic(3);
        String generatednumber = RandomStringUtils.randomNumeric(3);
        return (generatedstring+"@"+generatednumber);
    }
}
