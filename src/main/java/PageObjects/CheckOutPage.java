package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver){super(driver);}


    private final By radioExistingAddress =  By.xpath("//input[@id='input-shipping-existing']");
    private final By radioNewAddress = By.xpath("//input[@id='input-shipping-new']");
    private  final By labelCheckout = By.xpath("//div[@id='content']//h1");
    private final By labelShippingAddress = By.xpath("//div[@id='checkout-shipping-address']//legend");
    private final  By textFirstName = By.xpath("//input[@id='input-shipping-firstname']");
    private final By textLastName = By.xpath( "//input[@id='input-shipping-lastname']");
    private final By textCompany = By.xpath("//input[@id='input-shipping-company']");
    private final By textAddress1 = By.xpath("(//input[contains(@id,'input-shipping-address')])[1]");
    private final By textAddress2 = By.xpath("(//input[contains(@id,'input-shipping-address')])[2]");
    private final By textCity = By.xpath("//input[@id='input-shipping-city']");
    private final By textPostCode = By.xpath("//input[@id='input-shipping-postcode']");
    private final By selectDrpdwnCountry = By.xpath("//select[@id='input-shipping-country']");
    private final By selectDrpdwnState = By.xpath("//select[@id='input-shipping-zone']");
    private final By buttonContinueAddress  = By.xpath("//button[@id='button-shipping-address']");
    private final By labelShippingMethod  = By.xpath("//legend[normalize-space()='Shipping Method']");
    private final By labelPaymentMethod = By.xpath( "//legend[normalize-space()='Payment Method']");
    private final By buttonShippingMethods  = By.xpath("//button[@id='button-shipping-methods']");
    private final By optionShippingRate  = By.xpath("//input[@id='input-shipping-method-flat-flat']");
    private final By buttonContinueShippingMethod = By.xpath( "//button[@id='button-shipping-method']");
    private final By buttonPaymentMethod  = By.xpath("//button[@id='button-payment-methods']");
    private final By optionCashonDelivery  = By.xpath("//input[@id='input-payment-method-cod-cod']");
    private final By buttonContinuePaymentMethod  = By.xpath( "//button[@id='button-payment-method']q");
    private final By textCommetOrder = By.xpath("//textarea[@id='input-comment']");
    private final By labelProductBrandCheckout = By.xpath("(//div[@id='checkout-confirm']//table//td[1])[1]");
    private final By labelOrderPrice  = By.xpath("(//div[@id='checkout-confirm']//table//td[2])[1]");
    private final By labelOrderSubTotalPrice = By.xpath("(//div[@id='checkout-confirm']//table//td[2])[2]");
    private final By labelEcoTaxOrder = By.xpath("(//div[@id='checkout-confirm']//table//td[2])[3]");
    private final By labelVatPrice = By.xpath("(//div[@id='checkout-confirm']//table//td[2])[4]");
    private final By labelFinalOrderPrice = By.xpath("(//div[@id='checkout-confirm']//table//td[2])[5]");
    private final By buttonConfirmOrder = By.xpath("//div[@id='checkout-payment']//button");


    public boolean isCheckoutPageDisplayed(){
        return actions.isDisplayed(labelCheckout);
    }

    public String getCheckoutHeading(){
        return actions.getText(labelCheckout);
    }
    public String getShippingAddressLabel(){ return actions.getText(labelShippingAddress);}
    public void selectExistingAddress(){ actions.click(radioExistingAddress); }
    public void selectNewAddress(){  actions.click(radioNewAddress); }


    public void checkout(
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

        selectNewAddress();
        actions.type(textFirstName, firstName);
        actions.type(textLastName,lastName);
        actions.type(textCompany,company);
        actions.type(textAddress1, address1);
        actions.type(textAddress2,address2);
        actions.type(textCity,city);
        actions.type(textPostCode,postCode);
        actions.selectByVisibleText(selectDrpdwnCountry,country);
        actions.selectByVisibleText(selectDrpdwnState,state);
        actions.click(buttonContinueAddress);
        actions.click(buttonShippingMethods);
        actions.click(buttonPaymentMethod);
        actions.type(textCommetOrder, comment);
        actions.click(buttonConfirmOrder);
    }

    public void productsInCartInfo(){
        String productName = actions.getText(labelProductBrandCheckout);
        String orderPrice = actions.getText(labelOrderPrice);
        String subTotalPrice = actions.getText(labelOrderSubTotalPrice);
        String EcoTaxPrice = actions.getText(labelEcoTaxOrder);
        String vatPrice = actions.getText(labelVatPrice);
        String finalOrderPrice = actions.getText(labelFinalOrderPrice);

    }









}
