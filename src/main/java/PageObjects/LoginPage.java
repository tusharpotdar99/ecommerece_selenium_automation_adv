package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Login']")
    WebElement breadcrumbLogin;

    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement txtNewCustomer;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement txtReturningCustomer;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement textEmailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath = "//form//a[normalize-space()='Forgotten Password']")
    WebElement buttonForgottenPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//aside//a")
    List<WebElement> sidePanelLinks;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement warningMessage;

    public void setEmail(String email){
        textEmailAddress.sendKeys(email);
    }

    public void setPassword(String password){
        textPassword.sendKeys(password);
    }

    public void clickLogin(){
        buttonLogin.click();
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void clickForgotPassword(){
        buttonForgottenPassword.click();
    }

    public boolean isLoginPageDisplayed(){
        return txtReturningCustomer.isDisplayed();
    }

    public String getWarningMessage(){
        return warningMessage.getText();
    }

    public String getBreadcrumbText(){
        return breadcrumbLogin.getText();
    }

    public void clickSidePanelLink(String linkName){
        for(WebElement link : sidePanelLinks){
            if(link.getText().equalsIgnoreCase(linkName)){
                link.click();
                break;
            }
        }
    }



}
