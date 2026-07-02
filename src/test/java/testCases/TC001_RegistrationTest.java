package testCases;

import PageObjects.AccountRegistrationPage;
import PageObjects.AccountSuccessPage;
import PageObjects.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_RegistrationTest {

    private static final Logger logger = LogManager.getLogger(TC001_RegistrationTest.class);

    @Test(
            priority = 2,
            description = "Verify user can register with valid details"
    )
    public void verifyUserRegistration() {

        logger.info("********* Starting TC_001_RegistrationTest With Valid Credential *********");

        try {

            HomePage homePage = new HomePage(driver);

            homePage.header().clickMyAccount();
            logger.info("Clicked My Account");

            homePage.header().clickRegister();
            logger.info("Clicked Register");

            AccountRegistrationPage registrationPage =
                    new AccountRegistrationPage(driver);

            String email =
                    "tushar" + System.currentTimeMillis() + "@gmail.com";

            AccountSuccessPage successPage = registrationPage.register(
                    "Tushar",
                    "Potdar",
                    email,
                    "Test@123",
                    true
            );

            logger.info("Registration form submitted");

            Assert.assertTrue(
                    successPage.isRegistrationSuccessful(),
                    "Registration was unsuccessful."
            );

            logger.info("Registration completed successfully.");

        } catch (Exception e) {

            logger.error("Registration test failed", e);

            Assert.fail(e.getMessage());

        }

        logger.info("********** Registration Test Finished **********");
    }
}
