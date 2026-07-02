package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtility {

    public static void scrollIntoView(WebDriver driver,
                                      By locator){
        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});",
                element);

    }

    public static void waitForElement(WebDriver driver,
                                      By locator){

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
    }

    public static void waitForElementToBeClickable(WebDriver driver,
                                      By locator){

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .elementToBeClickable(locator));
    }
}