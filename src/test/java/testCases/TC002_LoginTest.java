package testCases;

import Base.BasePage;
import Base.BaseTest;
import DataProviders.LoginDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.ConfigReader;


public class TC002_LoginTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TC002_LoginTest.class);

    @Test(priority = 1, enabled = true, description = "verify user can login with valid credentials.")
    public void verifyValidLogin(){
        logger.info("********* Starting TC_002_LoginTest With Valid Credential *********");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.header().clickMyAccount();
            logger.info("Click my account");
            homePage.header().clickLogin();
            logger.info("Click login");

            LoginPage loginPage = new LoginPage(driver);
            MyAccountPage myAccountPage = loginPage.login(ConfigReader.getUsername(),ConfigReader.getPassword());
            logger.info("Passed Username and Password and Clicked Login");

            Assert.assertTrue(myAccountPage.IsMyAccountPageExists());
            logger.info("TEST PASSED");

        }
        catch (Exception e){
            Assert.fail(e.getMessage());
            logger.info("TEST FAILED");
        }

        logger.info("********* Finished TC_002_LoginTest With Valid Credential  *********");
    }

    @Test(priority = 2, enabled = true, description = "Verify warning message for invalid credentials")
    public void verifyInvalidLogin(){
        logger.info("********* Starting TC_002_LoginTest with Invalid credentials *********");

        try {


            HomePage homePage = new HomePage(driver);
            homePage.header().clickMyAccount();
            logger.info("Click my account");
            homePage.header().clickLogin();
            logger.info("Click login");


            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginWithInvalidCredentials(
                    ConfigReader.getInvalidUser(),
                    ConfigReader.getInvalidPassword());
            logger.info("Passed Invalid Username and Password and Clicked Login");


            Assert.assertTrue(
                    loginPage.getWarningMessage()
                            .contains("Warning"));
            logger.info("TEST PASSED");

        }
        catch (Exception e){
            Assert.fail(e.getMessage());
            logger.info("TEST FAILED");
        }

        logger.info("********* Finished TC_002_LoginTest with invalid credentials*********");
    }

    @Test(priority = 3, enabled = true, description = "verify user can login with data-driven testing", dataProvider = "LoginData", dataProviderClass = LoginDataProvider.class)
    public void verifyLoginDDT(String username, String password, String expectedResult){
        logger.info("********* Starting TC_002_LoginTest With Test Data *********");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.header().clickMyAccount();
            logger.info("Click my account");
            homePage.header().clickLogin();
            logger.info("Click login");

            LoginPage loginPage = new LoginPage(driver);
            MyAccountPage myAccountPage = loginPage.login(username, password);
            logger.info("Entered Username: {}", username);
            logger.info("Clicked Login button");

            boolean isLoginSuccessful = myAccountPage.IsMyAccountPageExists();

            if (expectedResult.equalsIgnoreCase("Valid")) {

                Assert.assertTrue(isLoginSuccessful,
                        "Expected login to be successful.");

                logger.info("Login successful as expected.");

                // Logout so next iteration starts from a clean state

            } else {

                Assert.assertFalse(isLoginSuccessful,
                        "Expected login to fail.");

                logger.info("Invalid login verified successfully.");
            }

        } catch (Exception e) {

            logger.error("Exception occurred during DDT execution", e);
            Assert.fail(e.getMessage());

        }

        logger.info("********* Finished TC_003_LoginTest_DDT *********");
    }



}
