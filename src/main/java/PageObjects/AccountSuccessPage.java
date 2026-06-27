package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage extends BasePage {

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    private final By pageHeading =
            By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

    private final By successMessage =
            By.xpath("//div[@id='content']/p[1]");

    private final By memberPrivilegeMessage =
            By.xpath("//div[@id='content']/p[2]");

    private final By contactStoreOwnerMessage =
            By.xpath("//div[@id='content']/p[3]");

    private final By emailConfirmationMessage =
            By.xpath("//div[@id='content']/p[4]");

    private final By continueButton =
            By.linkText("Continue");

    public boolean isPageHeadingDisplayed() {
        return actions.isDisplayed(pageHeading);
    }

    public String getPageHeading() {
        return actions.getText(pageHeading);
    }

    public String getSuccessMessage() {
        return actions.getText(successMessage);
    }

    public String getMemberPrivilegeMessage() {
        return actions.getText(memberPrivilegeMessage);
    }

    public String getContactStoreOwnerMessage() {
        return actions.getText(contactStoreOwnerMessage);
    }

    public String getEmailConfirmationMessage() {
        return actions.getText(emailConfirmationMessage);
    }


    public MyAccountPage clickContinue() {
        actions.click(continueButton);
        return new MyAccountPage(driver);
    }


    public boolean isAccountCreatedSuccessfully() {

        return isPageHeadingDisplayed()
                && getPageHeading().contains("Your Account Has Been Created!");
    }

}