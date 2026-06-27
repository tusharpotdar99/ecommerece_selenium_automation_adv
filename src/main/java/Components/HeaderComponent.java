package Components;

import Base.BasePage;
import PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver){
        super(driver);
    }

    private final By logo = By.xpath("//img[@title='Your Store']");
    private final By phoneNumber = By.xpath("//span[normalize-space()='123456789']");
    private final By myAccount = By.xpath("//span[normalize-space()='My Account']");
    private final By register = By.xpath("//a[normalize-space()='Register']");
    private final By login = By.xpath("//a[normalize-space()='Login']");
    private final By wishList = By.xpath("//a[contains(@id,'wishlist-total')]");
    private final By shoppingCart = By.xpath("//a[@title='Shopping Cart']");
    private final By checkout = By.xpath("//span[normalize-space()='Checkout']");
    private final By searchBox = By.xpath("//input[@placeholder='Search']");
    private final By searchButton = By.xpath("//i[@class='fa-solid fa-magnifying-glass']");
    private final By cartTotal = By.xpath("//span[@id='cart-total']");

    public void searchProduct(String product) {
        actions.type(searchBox, product);
        actions.click(searchButton);
    }

    public LoginPage navigateToLoginPage(){
        actions.click(myAccount);
        actions.click(login);
        return new LoginPage(driver);
    }

    public void clickMyAccount() {
        actions.click(myAccount);
    }

    public void clickRegister() {
        actions.click(register);
    }

    public void clickLogin() {
        actions.click(login);
    }

    public void openCart() {
        actions.click(shoppingCart);
    }

    public String getPhoneNumber() {
        return actions.getText(phoneNumber);
    }

    public String getCartTotal() {
        return actions.getText(cartTotal);
    }

    public boolean isLogoDisplayed() {
        return actions.isDisplayed(logo);
    }

    public boolean isMyAccoutDisplayed(){
        return actions.isDisplayed(myAccount);
    }

}
