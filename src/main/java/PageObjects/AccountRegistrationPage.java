package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountRegistrationPage extends BasePage {


    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement breadcrumbRegister;

    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement txtRegisterAccount;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement textFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement textLastName;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement textEmail;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement textTelephone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement textConfirmPassword;

    @FindBy(xpath = "//input[@value='1'][@name='newsletter']")
    WebElement radioNewsletterYes;

    @FindBy(xpath = "//input[@value='0'][@name='newsletter']")
    WebElement radioNewsletterNo;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement radioBoxSubscribe;

    @FindBy(xpath = "//label[normalize-space()='No']")
    WebElement radioBoxUnSubscribe;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkboxPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement textsuccessMessageConfirmation;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinueAfterRegister;

    @FindBy(xpath = "//a[normalize-space()='contact us']")
    WebElement linkContactUsOnSuccess;

    @FindBy(xpath = "//aside//a")
    List<WebElement> sidePanelLinks;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    WebElement warningMessage;


    public void setFirstName(String firstName){
        textFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        textLastName.sendKeys(lastName);
    }

    public void setEmail(String email){
        textEmail.sendKeys(email);
    }

    public void setTelephone(String telephone){
        textTelephone.sendKeys(telephone);
    }

    public void setPassword(String password){
        textPassword.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        textConfirmPassword.sendKeys(confirmPassword);
    }

    public void checkSubscribe(){
        radioBoxSubscribe.click();
    }

    public void selectNewsletter(String option){

        if(option.equalsIgnoreCase("yes")){

            radioNewsletterYes.click();
        }
        else{

            radioNewsletterNo.click();
        }
    }

    public void checkPolicyCheckbox(){
        checkboxPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public boolean isRegistrationPageDisplayed(){
        return txtRegisterAccount.isDisplayed();
    }

    public String getWarningMessage(){
        return warningMessage.getText();
    }

    public boolean isRegistrationSuccessful(){
        return textsuccessMessageConfirmation.isDisplayed();
    }

    public String getConfirmationMessage(){
        try{
            return (textsuccessMessageConfirmation.getText());
        } catch (Exception e){
            return (e.getMessage());
        }
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










