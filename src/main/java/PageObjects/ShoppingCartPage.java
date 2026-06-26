package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//div[@id='checkout-cart']//li[2]")
    WebElement breadcrumbShoppingCart;

    @FindBy(xpath = "//h1[normalize-space()='Shopping Cart']")
    WebElement labelShoppingCart;

    @FindBy(xpath = "//div[@id='checkout-cart']//p")
    WebElement labelShoppingCartEmpty;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement buttonContinueHomeProductSearch;

    @FindBy(xpath = "//h1")
    WebElement LabelShoppingCartWeight;

    @FindBy(xpath = "//table//tr[1]//td[1]//img")
    WebElement imgProductCart;

    @FindBy(xpath = "//table//tr[1]//td[2]")
    WebElement labelProductInCart;

    @FindBy(xpath = "//input[@name='quantity']")
    WebElement txtQuantityCartProd;

    @FindBy(xpath = "//button[@title='Update']")
    WebElement buttonUpdateShoppingCart;

    @FindBy(xpath = "//a[@title='Remove']")
    WebElement buttonRemoveProductFromCart;

    @FindBy(xpath = "(//tbody//tr[1]//td[4])[2]")
    WebElement labelUnitPriceProduct;

    @FindBy(xpath = "(//tbody//tr[1]//td[5])[1]")
    WebElement labelProductPriceByQuantity;

    @FindBy(xpath = "(//tfoot[@id='checkout-total']//td[@class='text-end'])[2]")
    WebElement labelSubTotal;

    @FindBy(xpath = "(//tfoot[@id='checkout-total']//td[@class='text-end'])[4]")
    WebElement LabelEcoTax;

    @FindBy(xpath = "(//tfoot[@id='checkout-total']//td[@class='text-end'])[6]")
    WebElement labelVatPrice;

    @FindBy(xpath = "(//tfoot[@id='checkout-total']//td[@class='text-end'])[8]")
    WebElement labelTotalofAllPrice;

    @FindBy(xpath = "//h2[normalize-space()='What would you like to do next?']")
    WebElement labelNextOperations;

    @FindBy(xpath = "//p[contains(text(),'Choose if you have a discount code or reward point')]")
    WebElement labelInstructionsCodeReward;

    @FindBy(xpath = "//button[normalize-space()='Estimate Shipping & Taxes']")
    WebElement buttonExpandEstimateShipping;

    @FindBy(xpath = "//select[@id='input-country']")
    WebElement selectDrpdwnCountryShippingEst;

    @FindBy(xpath = "//select[@id='input-zone']")
    WebElement selectDrpdwnStateShippingEst;

    @FindBy(xpath = "//input[@id='input-postcode']")
    WebElement textPostCodeShippingEst;

    @FindBy(xpath = "//button[@id='button-quote']")
    WebElement buttonGetQuotesFoeShipEst;

    @FindBy(xpath = "//input[@id='input-coupon']")
    WebElement textCouponCode;

    @FindBy(xpath = "//button[normalize-space()='Remove']")
    WebElement buttonRemoveCoupon;

    @FindBy(xpath = "//button[normalize-space()='Apply Coupon']")
    WebElement buttonApplyCoupon;

    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    WebElement buttonContinueShipping;

    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement buttonCheckout;

    @FindBy(xpath = "//button[normalize-space()='Use Coupon Code']")
    WebElement buttonExpandUseCouponCode;



    public boolean isShoppingCartPageDisplayed(){
        return labelShoppingCart.isDisplayed();
    }

    public String getBreadcrumbText(){
        return breadcrumb.getText();
    }

    public String getEmptyCartMessage(){
        return labelShoppingCartEmpty.getText();
    }

    public String getCartProductName(){
        return labelProductInCart.getText();
    }

    public String getUnitPrice(){
        return labelUnitPriceProduct.getText();
    }

    public String getPriceByQuantity(){
        return labelProductPriceByQuantity.getText();
    }

    public String getSubTotal(){
        return labelSubTotal.getText();
    }

    public String getEcoTax(){
        return LabelEcoTax.getText();
    }

    public String getVatPrice(){
        return labelVatPrice.getText();
    }

    public String getTotalPrice(){
        return labelTotalofAllPrice.getText();
    }

    public void enterProductQuantity(String quantity){
        txtQuantityCartProd.clear();
        txtQuantityCartProd.sendKeys(quantity);
    }

    public void clickUpdateCart(){
        buttonUpdateShoppingCart.click();
    }

    public void updateProductQuantity(String quantity){
        enterProductQuantity(quantity);
        clickUpdateCart();
    }

    public void removeProductFromCart(){
        buttonRemoveProductFromCart.click();
    }

    public void clickContinueButton(){
        buttonContinueHomeProductSearch.click();
    }

    public void clickContinueShopping(){
        buttonContinueShipping.click();
    }

    public void clickCheckout(){
        buttonCheckout.click();
    }

    public void expandEstimateShipping(){
        buttonExpandEstimateShipping.click();
    }

    public void selectCountry(String country){
        Select select = new Select(selectDrpdwnCountryShippingEst);
        select.selectByVisibleText(country);
    }

    public void selectState(String state){
        Select select = new Select(selectDrpdwnStateShippingEst);
        select.selectByVisibleText(state);
    }

    public void enterPostCode(String postCode){
        textPostCodeShippingEst.clear();
        textPostCodeShippingEst.sendKeys(postCode);
    }

    public void clickGetQuotes(){
        buttonGetQuotesFoeShipEst.click();
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


    public void expandCouponSection(){
        buttonExpandUseCouponCode.click();
    }

    public void enterCouponCode(String coupon){
        textCouponCode.clear();
        textCouponCode.sendKeys(coupon);
    }

    public void clickApplyCoupon(){
        buttonApplyCoupon.click();
    }

    public void applyCoupon(String coupon){
        expandCouponSection();
        enterCouponCode(coupon);
        clickApplyCoupon();
    }

    public void removeCoupon(){
        buttonRemoveCoupon.click();
    }




}
