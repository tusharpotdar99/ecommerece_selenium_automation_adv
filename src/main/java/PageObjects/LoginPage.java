package PageObjects;

import Base.BasePage;
import Components.AccountSidePanelComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    private final AccountSidePanelComponent sidePanel;

    public LoginPage(WebDriver driver){
        super(driver);
        sidePanel = new AccountSidePanelComponent(driver);
    }
    private final By breadcrumb = By.xpath("//ul[@class='breadcrumb']");
    private final By breadcrumbLogin =  By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Login']");
    private final By txtNewCustomer = By.xpath("//h2[normalize-space()='New Customer']");
    private final By btnContinue = By.xpath( "//a[normalize-space()='Continue']");
    private final By txtReturningCustomer = By.xpath("//h2[normalize-space()='Returning Customer']");
    private final By emailTextBox = By.xpath("//input[@id='input-email']");
    private final By passwordTextBox = By.xpath("//input[@id='input-password']");
    private final By buttonForgottenPassword = By.xpath("//form//a[normalize-space()='Forgotten Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By warningMessage = By.xpath("//div[contains(@class,'alert-danger')]");

    public MyAccountPage login(String email, String password){

        actions.type(emailTextBox, email);
        actions.type(passwordTextBox, password);
        actions.click(loginButton);

        return new MyAccountPage(driver);

    }


    public LoginPage loginWithInvalidCredentials(
            String email,
            String password) {

        actions.type(emailTextBox, email);

        actions.type(passwordTextBox, password);

        actions.click(loginButton);

        return this;
    }

    public AccountSidePanelComponent sidePanel(){
        return sidePanel;
    }


    public String  getWarningMessage() {
        return actions.getText(warningMessage);
    }

//    public RegisterPage clickContinue() {
//
//        actions.click(continueButton);
//
//        return new RegisterPage(driver);
//    }


//    public ForgotPasswordPage clickForgotPassword() {
//
//        actions.click(forgotPasswordLink);
//
//        return new ForgotPasswordPage(driver);
//    }


}
