package testCases;

import Base.BaseTest;
import PageObjects.AccountRegistrationPage;
import PageObjects.AccountSuccessPage;
import PageObjects.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RegistrationData;
import utilities.TestDataExcelUtility;
import utilities.TestDataGenerator;

public class TC001_RegistrationTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TC001_RegistrationTest.class);

    @Test(
            enabled = true,
            priority = 1,
            description = "Verify user can register with valid details"
    )
    public void verifyUserRegistration() {

        logger.info("********* Starting TC_001_RegistrationTest With Valid Credential *********");

        try {
            RegistrationData user = TestDataGenerator.generateUser();

            HomePage homePage = new HomePage(driver);

            homePage.header().clickMyAccount();
            logger.info("Clicked My Account");

            homePage.header().clickRegister();
            logger.info("Clicked Register");

            AccountRegistrationPage registrationPage =
                    new AccountRegistrationPage(driver);

            AccountSuccessPage successPage = registrationPage.register(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPassword(),
                    true
            );

            logger.info("Registration form submitted");

            Assert.assertTrue(
                    successPage.isAccountCreatedSuccessfully(),
                    "Registration was unsuccessful."
            );

            TestDataExcelUtility.appendRegistrationData(user);

            logger.info("Registration completed successfully.");

        } catch (Exception e) {

            logger.error("Registration test failed", e);

            Assert.fail(e.getMessage());

        }

        logger.info("********** Registration Test Finished **********");
    }
}
