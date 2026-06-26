package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductOrderConfirmSuccessPage extends BasePage {

    public ProductOrderConfirmSuccessPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[contains(text(),'Success')]")
    WebElement breadcrumbSuccess;

    @FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
    WebElement labelOrderPlaced;

    @FindBy(xpath = "//div[@id='content']//p[1]")
    WebElement labelOrderProcessed;

    @FindBy(xpath = "//a[normalize-space()='my account']")
    WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='history']")
    WebElement linkOrderHistory;

    @FindBy(xpath = "//a[normalize-space()='downloads']")
    WebElement linkDownloads;

    @FindBy(xpath = "//a[normalize-space()='store owner']")
    WebElement linkStoreOwner;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement buttonContinueHome;


    public boolean isOrderSuccessPageDisplayed(){
        return labelOrderPlaced.isDisplayed();
    }

    public String getBreadcrumbText(){
        return breadcrumb.getText();
    }

    public String getSuccessHeading(){
        return labelOrderPlaced.getText();
    }

    public String getOrderProcessedMessage(){
        return labelOrderProcessed.getText();
    }

    public void clickMyAccount(){
        linkMyAccount.click();
    }

    public void clickOrderHistory(){
        linkOrderHistory.click();
    }

    public void clickDownloads(){
        linkDownloads.click();
    }

    public void clickStoreOwner(){
        linkStoreOwner.click();
    }

    public void clickContinue(){
        buttonContinueHome.click();
    }




}
