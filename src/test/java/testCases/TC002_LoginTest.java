package testCases;

import Base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.CaptureScreen;
import utilities.ConfigReader;

import java.io.IOException;

public class TC002_LoginTest extends BasePage {

    private static final Logger logger = LogManager.getLogger(TC002_LoginTest.class);
    public TC002_LoginTest(WebDriver driver){
        super(driver);
    }

    @Test(enabled = true, description = "verify user can login with valid credentials.")
    public void verify_login_with_valid_credentials(){
        logger.info("********* Starting TC_002_LoginTest With Valid Credential *********");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.header().clickMyAccount();
            homePage.header().clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            MyAccountPage myAccountPage = loginPage.login(ConfigReader.getUsername(),ConfigReader.getPassword());

            Assert.assertTrue(myAccountPage.isDisplayed());
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            //My Account
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.IsMyAccountPageExists();

//        Assert.assertEquals(targetPage, true, "Login failed");
            Assert.assertTrue(targetPage);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }

        logger.info("********* Finished TC_002_LoginTest With Valid Credential  *********");
    }

    @Test(enabled = false)
    public void verify_login_with_invalid_credentials(){
        logger.info("********* Starting TC_002_LoginTest with Invalid credentials *********");

        try {


            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(properties.getProperty("invalidemail"));
            loginPage.setPassword(properties.getProperty("invalidpassword"));
            loginPage.clickLogin();

            //My Account
            boolean targetPage = driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.");

//        Assert.assertEquals(targetPage, true, "Login failed");
            Assert.assertTrue(targetPage);
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }

        logger.info("********* Finished TC_002_LoginTest with invalid credentials*********");
    }

    @Test(enabled = false)
    public void verify_login_with_empty_credentials(){

        logger.info("********* Starting TC_002_LoginTest With Empty Credential *********");

        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail("");
            loginPage.setPassword("");
            loginPage.clickLogin();

            boolean targetPage =
                    driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.");

            Assert.assertTrue(targetPage);

        }
        catch (Exception e){

            Assert.fail(e.getMessage());
        }

        logger.info("********* Finished TC_002_LoginTest With Empty Credential *********");
    }

    @Test(enabled = false)
    public void verify_login_with_invalid_password(){

        logger.info("********* Starting TC_002_LoginTest With Invalid Password *********");

        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(properties.getProperty("email"));
            loginPage.setPassword("invalidpassword");
            loginPage.clickLogin();

            boolean targetPage =
                    driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password.");

            Assert.assertTrue(targetPage);

        }
        catch (Exception e){

            Assert.fail(e.getMessage());
        }

        logger.info("********* Finished TC_002_LoginTest With Invalid Password *********");
    }


    @Test(enabled = true)
    public void verify_login_with_invalid_email() throws IOException {

        logger.info("********* Starting TC_002_LoginTest With Invalid Email *********");

        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail("invalid@gmail.com");
            loginPage.setPassword(properties.getProperty("password"));
            loginPage.clickLogin();

            boolean targetPage =
                    driver.getPageSource().contains("Warning: No match for E-Mail Address and/or Password");

            CaptureScreen.captureScreen(driver, "LoginTest");
//            Assert.assertTrue(targetPage);

            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning"));

        }
        catch (Exception e){
            CaptureScreen.captureScreen(driver, "LoginTest");

            Assert.fail(e.getMessage());
        }

        logger.info("********* Finished TC_002_LoginTest With Invalid Email *********");
    }
}
