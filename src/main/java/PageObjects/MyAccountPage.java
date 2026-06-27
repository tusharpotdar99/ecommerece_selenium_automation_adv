package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    private final By myAccountHeading = By.xpath("//h1[normalize-space()='My Account']");
    private final By myOrderHeading = By.xpath("//h2[normalize-space()='My Orders']");
    private final By myAffilateAccountHeading = By.xpath("//h2[normalize-space()='My Orders']");
    private final By newsLetterHeading = By.xpath("//h2[normalize-space()='Newsletter']");





    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement linkLogout;

    public boolean IsMyAccountPageExists(){
        try{
            return (messageHeading.isDisplayed());
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickLogout(){
        linkLogout.click();
    }


}
