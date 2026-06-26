package Base;

import Actions.ElementActions;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {

    protected WebDriver driver;
    protected ElementActions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.actions = new ElementActions(driver);
    }

}
