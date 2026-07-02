package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductOrderConfirmSuccessPage extends BasePage {

    public ProductOrderConfirmSuccessPage(WebDriver driver){super(driver);}

    private final By labelOrderPlaced = By.xpath("//h1[contains(text(),'Your order has been placed!')]");
    private final By labelOrderProcessed = By.xpath("//div[@id='content']//p[1]");
    private final By linkMyAccount = By.xpath("//a[normalize-space()='my account']");
    private final By linkOrderHistory = By.xpath("//a[normalize-space()='history']");
    private final By linkDownloads = By.xpath("//a[normalize-space();='downloads']");
    private final By linkStoreOwner = By.xpath("//a[normalize-space()='store owner']");
    private final By buttonContinueHome = By.xpath("//a[normalize-space()='Continue']");
    private final By successMessage = By.xpath("//div[@id = 'content']//p[1]");
    private final By orderHistoryCheck = By.xpath("//div[@id = 'content']//p[2]");
    private final By purchaseview = By.xpath("//div[@id = 'content']//p[3]");
    private final By questionsDir = By.xpath("//div[@id = 'content']//p[4]");
    private final By thankYou = By.xpath("//div[@id = 'content']//p[5]");


    public boolean isOrderSuccessPageDisplayed(){
        return actions.isDisplayed(labelOrderPlaced);
    }

    public String getSuccessHeading(){
        return actions.getText(labelOrderPlaced);
    }

    public String getOrderProcessedMessage(){
        return actions.getText(labelOrderProcessed);
    }

    public void clickMyAccount(){
        actions.click(linkMyAccount);
    }

    public void clickOrderHistory(){
        actions.click(linkOrderHistory);
    }

    public void clickDownloads(){
        actions.click(linkDownloads);
    }

    public void clickStoreOwner(){
        actions.click(linkStoreOwner);
    }

    public void clickContinue(){
        actions.click(buttonContinueHome);
    }




}
