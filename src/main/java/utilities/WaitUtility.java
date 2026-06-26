package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtility {

    public static void waitForElement(WebDriver driver,
                                      WebElement element){

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .visibilityOf(element));
    }
}