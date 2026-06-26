package testCases;

import Base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {

        logger.info("********* starting TC003_LoginDDT *********");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setEmail(email);
            loginPage.setPassword(password);
            loginPage.clickLogin();

            //My Account
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.IsMyAccountPageExists();


            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            logger.error("Test Failed : ",e);
            Assert.fail(e.getMessage());
        }



        logger.info("********* Finished TC_003_LoginTest *********");


    }
}
