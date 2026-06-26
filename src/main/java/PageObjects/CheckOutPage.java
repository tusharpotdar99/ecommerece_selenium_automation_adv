package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement breadcrumbCheckout;

    @FindBy(xpath = "//input[@id='input-shipping-existing']")
    WebElement radioExistingAddress;

    @FindBy(xpath = "//input[@id='input-shipping-new']")
    WebElement radioNewAddress;

    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement labelCheckout;

    @FindBy(xpath = "//div[@id='checkout-shipping-address']//legend")
    WebElement labelShippingAddress;

    @FindBy(xpath = "//input[@id='input-shipping-firstname']")
    WebElement textFirstName;

    @FindBy(xpath = "//input[@id='input-shipping-lastname']")
    WebElement textLastName;

    @FindBy(xpath = "//input[@id='input-shipping-company']")
    WebElement textCompany;

    @FindBy(xpath = "(//input[contains(@id,'input-shipping-address')])[1]")
    WebElement textAddress1;

    @FindBy(xpath = "(//input[contains(@id,'input-shipping-address')])[2]")
    WebElement textAddress2;

    @FindBy(xpath = "//input[@id='input-shipping-city']")
    WebElement textCity;

    @FindBy(xpath = "//input[@id='input-shipping-postcode']")
    WebElement textPostCode;

    @FindBy(xpath = "//select[@id='input-shipping-country']")
    WebElement selectDrpdwnCountry;

    @FindBy(xpath = "//select[@id='input-shipping-zone']")
    WebElement selectDrpdwnState;

    @FindBy(xpath = "//button[@id='button-shipping-address']")
    WebElement buttonContinueAddress;

    @FindBy(xpath = "//legend[normalize-space()='Shipping Method']")
    WebElement labelShippingMethod;

    @FindBy(xpath = "//legend[normalize-space()='Payment Method']")
    WebElement labelPaymentMethod;

    @FindBy(xpath = "//button[@id='button-shipping-methods']")
    WebElement buttonShippingMethods;

    @FindBy(xpath = "//input[@id='input-shipping-method-flat-flat']")
    WebElement optionShippingRate;

    @FindBy(xpath = "//button[@id='button-shipping-method']")
    WebElement buttonContinueShippingMethod;

    @FindBy(xpath = "//button[@id='button-payment-methods']")
    WebElement buttonPaymentMethod;

    @FindBy(xpath = "//input[@id='input-payment-method-cod-cod']")
    WebElement optionCashonDelivery;

    @FindBy(xpath = "//button[@id='button-payment-method']q")
    WebElement buttonContinuePaymentMethod;

    @FindBy(xpath = "//textarea[@id='input-comment']")
    WebElement textCommetOrder;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[1])[1]")
    WebElement labelProductBrandCheckout;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[2])[1]")
    WebElement labelOrderPrice;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[2])[2]")
    WebElement labelOrderSubTotalPrice;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[2])[3]")
    WebElement labelEcoTaxOrder;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[2])[4]")
    WebElement labelVatPrice;

    @FindBy(xpath = "(//div[@id='checkout-confirm']//table//td[2])[5]")
    WebElement labelFinalOrderPrice;

    @FindBy(xpath = "//div[@id='checkout-payment']//button")
    WebElement buttonConfirmOrder;

    public boolean isCheckoutPageDisplayed(){
        return labelCheckout.isDisplayed();
    }

    public String getBreadcrumbText(){
        return breadcrumb.getText();
    }

    public String getCheckoutHeading(){
        return labelCheckout.getText();
    }

    public String getShippingAddressLabel(){
        return labelShippingAddress.getText();
    }

    public void selectExistingAddress(){
        radioExistingAddress.click();
    }

    public void selectNewAddress(){
        radioNewAddress.click();
    }

    public void enterFirstName(String firstName){
        textFirstName.clear();
        textFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        textLastName.clear();
        textLastName.sendKeys(lastName);
    }

    public void enterCompany(String company){
        textCompany.clear();
        textCompany.sendKeys(company);
    }

    public void enterAddress1(String address1){
        textAddress1.clear();
        textAddress1.sendKeys(address1);
    }

    public void enterAddress2(String address2){
        textAddress2.clear();
        textAddress2.sendKeys(address2);
    }

    public void enterCity(String city){
        textCity.clear();
        textCity.sendKeys(city);
    }

    public void enterPostCode(String postCode){
        textPostCode.clear();
        textPostCode.sendKeys(postCode);
    }

    public void selectCountry(String country){
        Select select = new Select(selectDrpdwnCountry);
        select.selectByVisibleText(country);
    }

    public void selectState(String state){
        Select select = new Select(selectDrpdwnState);
        select.selectByVisibleText(state);
    }

    public void clickContinueAddress(){
        buttonContinueAddress.click();
    }

    public void enterShippingAddress(
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String city,
            String postCode,
            String country,
            String state){

        selectNewAddress();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress1(address1);
        enterAddress2(address2);
        enterCity(city);
        enterPostCode(postCode);
        selectCountry(country);
        selectState(state);
        clickContinueAddress();
    }

    public void clickShippingMethods(){
        buttonShippingMethods.click();
    }

    public void clickPaymentMethods(){
        buttonPaymentMethod.click();
    }

    public void enterOrderComment(String comment){
        textCommetOrder.clear();
        textCommetOrder.sendKeys(comment);
    }

    public String getProductBrand(){
        return labelProductBrandCheckout.getText();
    }

    public String getOrderPrice(){
        return labelOrderPrice.getText();
    }

    public String getSubTotalPrice(){
        return labelOrderSubTotalPrice.getText();
    }

    public String getEcoTax(){
        return labelEcoTaxOrder.getText();
    }

    public String getVatPrice(){
        return labelVatPrice.getText();
    }

    public String getFinalOrderPrice(){
        return labelFinalOrderPrice.getText();
    }

    public void clickConfirmOrder(){
        buttonConfirmOrder.click();
    }

    public void completeCheckout(
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String city,
            String postCode,
            String country,
            String state,
            String comment){

        enterShippingAddress(
                firstName,
                lastName,
                company,
                address1,
                address2,
                city,
                postCode,
                country,
                state);

        clickShippingMethods();
        clickPaymentMethods();
        enterOrderComment(comment);
        clickConfirmOrder();
    }











}
