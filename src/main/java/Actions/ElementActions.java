package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementActions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final int DEFAULT_TIMEOUT = 20;

    public ElementActions(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    private WebElement waitForVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private List<WebElement> waitForAllVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //actions methods
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String text){
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator){
        return waitForVisibility(locator).getText().trim();
    }



    //verification methods
    public boolean isDisplayed(By locator){
        return waitForVisibility(locator).isDisplayed();
    }

    public boolean isEnabled(By locator){
        return waitForVisibility(locator).isEnabled();
    }

    public boolean isSelected(By locator){
        return waitForVisibility(locator).isSelected();
    }
    public String getAttribute(By locator, String attribute){
        return waitForVisibility(locator).getAttribute(attribute);
    }

    public int getElementCount(By locator){
        return waitForAllVisible(locator).size();
    }

    public List<WebElement> getElements(By locator) {
        return waitForAllVisible(locator);
    }

    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(waitForVisibility(locator));
        select.selectByVisibleText(text);
    }

    public void selectByValue(By locator, String value) {
        Select select = new Select(waitForVisibility(locator));
        select.selectByValue(value);
    }

    public void selectByIndex(By locator, int index) {
        Select select = new Select(waitForVisibility(locator));
        select.selectByIndex(index);
    }


    private List<WebElement> findImmediately(By locator) {
        return driver.findElements(locator);
    }

    public boolean isPresent(By locator) {
        return !findImmediately(locator).isEmpty();
    }







}
