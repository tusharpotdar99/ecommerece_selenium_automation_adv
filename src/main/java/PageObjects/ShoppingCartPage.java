package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    private final By labelShoppingCart  = By.xpath("//h1[normalize-space()='Shopping Cart']");
    private final By labelShoppingCartEmpty  = By.xpath("//div[@id='checkout-cart']//p");
    private final By buttonContinueHomeProductSearch  = By.xpath("//a[normalize-space()='Continue']");
    private final By LabelShoppingCartWeight  = By.xpath("//h1");
    private final By imgProductCart  = By.xpath("//table//tr[1]//td[1]//img");
    private final By labelProductInCart  = By.xpath("//table//tr[1]//td[2]");
    private final By txtQuantityCartProd  = By.xpath("//input[@name='quantity']");
    private final By buttonUpdateShoppingCart  = By.xpath("//button[@title='Update']");
    private final By  buttonRemoveProductFromCart = By.xpath("//a[@title='Remove']");
    private final By labelUnitPriceProduct  = By.xpath("(//tbody//tr[1]//td[4])[2]");
    private final By labelProductPriceByQuantity  = By.xpath("(//tbody//tr[1]//td[5])[1]");
    private final By labelSubTotal  = By.xpath("(//tfoot[@id='checkout-total']//td[@class='text-end'])[2]");
    private final By labelEcoTax  = By.xpath("(//tfoot[@id='checkout-total']//td[@class='text-end'])[4]");
    private final By labelVatPrice  = By.xpath("(//tfoot[@id='checkout-total']//td[@class='text-end'])[6]");
    private final By labelTotalofAllPrice  = By.xpath("(//tfoot[@id='checkout-total']//td[@class='text-end'])[8]");
    private final By labelNextOperations  = By.xpath("//h2[normalize-space()='What would you like to do next?']");
    private final By labelInstructionsCodeReward  = By.xpath("//p[contains(text(),'Choose if you have a discount code or reward point')]");
    private final By buttonExpandEstimateShipping  = By.xpath("//button[normalize-space()='Estimate Shipping & Taxes']");
    private final By selectDrpdwnCountryShippingEst  = By.xpath("//select[@id='input-country']");
    private final By selectDrpdwnStateShippingEst  = By.xpath("//select[@id='input-zone']");
    private final By textPostCodeShippingEst  = By.xpath("//input[@id='input-postcode']");
    private final By buttonGetQuotesFoeShipEst  = By.xpath("//button[@id='button-quote']");
    private final By textCouponCode  = By.xpath("//input[@id='input-coupon']");
    private final By buttonRemoveCoupon  = By.xpath("//button[normalize-space()='Remove']");
    private final By buttonApplyCoupon  = By.xpath("//button[normalize-space()='Apply Coupon']");
    private final By buttonContinueShipping  = By.xpath("//a[normalize-space()='Continue Shopping']");
    private final By buttonCheckout  = By.xpath("//a[text()='Checkout']");
    private final By buttonExpandUseCouponCode  = By.xpath("//button[normalize-space()='Use Coupon Code']");


    public boolean isShoppingCartPageDisplayed(){
        return actions.isDisplayed(labelShoppingCart);
    }


    public String isCartEmptyMessage(){
        return actions.getText(labelShoppingCartEmpty);
    }

    public void getCartProductName(){
        String productInCart = actions.getText(labelProductInCart);
        String unitPrice = actions.getText(labelUnitPriceProduct);
        String productPriceByqnt = actions.getText(labelProductPriceByQuantity);
        String subTotal = actions.getText(labelSubTotal);
        String ecotax = actions.getText(labelEcoTax);
        String vatTax = actions.getText(labelVatPrice);
        String totalPrice = actions.getText(labelTotalofAllPrice);

    }

    public void updateProductQuantity(String quantity){
        actions.type(txtQuantityCartProd, quantity);
        actions.click(buttonUpdateShoppingCart);

    }


    public void removeProductFromCart(){
        actions.click(buttonRemoveProductFromCart);
    }

    public void redirectHomepage(){
        actions.click(buttonContinueHomeProductSearch);
    }

    public void clickContinueShopping(){
        actions.click(buttonContinueShipping);
    }

    public void Checkout(){
        actions.click(buttonCheckout);
    }

    public void expandEstimateShipping(){
        actions.click(buttonExpandEstimateShipping);
    }

    public void selectCountry(String country){
        actions.selectByVisibleText(selectDrpdwnCountryShippingEst, country);
    }

    public void selectState(String state){
        actions.selectByVisibleText(selectDrpdwnStateShippingEst, state);
    }

    public void enterPostCode(String postCode){
        actions.type(textPostCodeShippingEst, postCode);
    }

    public void clickGetQuotes(){
        actions.click(buttonGetQuotesFoeShipEst);
    }

    public void estimateShipping(
            String country,
            String state,
            String postCode){
        expandEstimateShipping();
        selectCountry(country);
        selectState(state);
        enterPostCode(postCode);
        clickGetQuotes();
    }


    public void applyCoupon(String coupon){
        actions.click(buttonExpandUseCouponCode);
        actions.type(textCouponCode, coupon);
        actions.click(buttonApplyCoupon);

    }

    public void removeCoupon(){
        actions.click(buttonRemoveCoupon);
    }




}
