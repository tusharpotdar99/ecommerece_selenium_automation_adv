package testCases;

import Base.BasePage;
import Base.BaseTest;
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



}
