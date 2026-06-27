package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountRegistrationPage extends BasePage {


    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    private final By registerPageHeading = By.xpath("//h1[normalize-space()='Register Account']");
    private final By personalDetailsTitle = By.xpath("//legend[normalize-space()='Your Personal Details']");
    private final By redirectedToLogin = By.xpath("//a[normalize-space()='login page']");
    private final By firstNameTextBox = By.xpath("//input[@id='input-firstname']");
    private final By lastNameTextBox = By.xpath("//input[@id='input-lastname']");
    private final By emailTextbox = By.xpath("//input[@id='input-email']");
    private final By passwordTextBox = By.xpath("//input[@id='input-password']");
    private final By newsletterCheckbox = By.xpath("//input[@type ='checkbox' and @id = 'input-newsletter']");
    private final By privacyPolicyCheck = By.xpath("//input[@type ='checkbox' and @name = 'agree']");

    private final By continueButton = By.xpath("//button[normalize-space()='Continue']");

    public boolean isDisplayedRegHeading(){
        return actions.isDisplayed(registerPageHeading);
    }

    public String getPageHeading(){
        return actions.getText(registerPageHeading);
    }

    public void enterFirstName(String value) {
        actions.type(firstNameTextBox, value);
    }

    public void enterLastName(String value) {
        actions.type(lastNameTextBox, value);
    }

    public void enterEmail(String value) {
        actions.type(emailTextbox, value);
    }

    public void enterPassword(String value) {
        actions.type(passwordTextBox, value);
    }

    public void subscribeNewsletter() {

        if (!actions.isSelected(newsletterCheckbox)) {
            actions.click(newsletterCheckbox);
        }
    }

    public void acceptPrivacyPolicy() {

        if (!actions.isSelected(privacyPolicyCheck)) {
            actions.click(privacyPolicyCheck);
        }
    }

    public AccountSuccessPage register(
            String first,
            String last,
            String emailAddress,
            String password,
            boolean subscribe){

        enterFirstName(first);
        enterLastName(last);
        enterEmail(emailAddress);
        enterPassword(password);

        if(subscribe){
            subscribeNewsletter();
        }

        acceptPrivacyPolicy();
        actions.click(continueButton);

        return new AccountSuccessPage(driver);
    }

    public LoginPage navigateToLoginPage() {

        actions.click(redirectedToLogin);

        return new LoginPage(driver);
    }




    }










