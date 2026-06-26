package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {


    @Test(enabled = true)
    public void verify_account_registration(){

        logger.info("********* Starting TC001_AccountRegistrationTest *********");

        try {


            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on MyAccount Link ");
            homePage.clickRegister();
            logger.info("Clicked on Register Link ");


            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("Providing customer Details");
            registrationPage.setFirstName(randomString().toUpperCase());
            registrationPage.setLastName(randomString().toUpperCase());
            registrationPage.setEmail(randomString() + "@gmail.com");
            registrationPage.setTelephone(randomNumber());
            String password = randomAlphaNumeric();
            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.checkSubscribe();
            registrationPage.checkPolicyCheckbox();
            registrationPage.clickContinue();

            logger.info("Validating expected Message..");
            String confirmMessage = registrationPage.getConfirmationMessage();

            Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
        }
        catch (Exception e){
            logger.error("Test Failed...");
            logger.debug("Debug Logs...");
            Assert.fail();
        }

        logger.info("********* Finished TC001_AccountRegistrationTest **********");

        }





}
