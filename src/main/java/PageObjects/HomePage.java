package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//strong[normalize-space()='$']")
    WebElement linkCurrencyDropDown;

    @FindBy(xpath = "//button[contains(text(),'€Euro')]")
    WebElement linkeuroCurrency;

    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement linkpoundCurrency;

    @FindBy(xpath = "//button[normalize-space()='$US Dollar']")
    WebElement linkdollarCurrency;

    @FindBy(xpath = "//span[normalize-space()='123456789']")
    WebElement linkphoneNumber;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement linkMyAccount; //    //a[@title='My Account']

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement linkLogin;

    @FindBy(xpath = "//a[contains(@id,'wishlist-total')]")
    WebElement linkWishList; // //a[@id='wishlist-total']//i[@class='fa fa-heart']

    @FindBy(xpath = "//a[@title = 'Shopping Cart']")
    WebElement linkShoppingCart;

    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    WebElement linkCheckOut;

    @FindBy(xpath = "//img[@title='Your Store']")
    WebElement linkAppTitle;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement linkSearchBox;

    @FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
    WebElement linkSearchGlassIcon;

    @FindBy(xpath = "//span[@id='cart-total']")
    WebElement linkCartItemTotal;

    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement linkDesktop;

    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement linkComponents;

    @FindBy(xpath = "//a[normalize-space()='Tablets']")
    WebElement linkTablets;

    @FindBy(xpath = "//a[normalize-space()='Software']")
    WebElement linkSoftware;

    @FindBy(xpath = "//a[normalize-space()='Phones & PDAs']")
    WebElement linkPhonesandPda;

    @FindBy(xpath = "//a[normalize-space()='Cameras']")
    WebElement linkCameras;

    @FindBy(xpath = "//a[normalize-space()='MP3 Players']")
    WebElement linkMp3Players;

    @FindBy(xpath = "//div[@class='product-thumb']//div[@class='image']")
    List<WebElement> linkproductImages;

    @FindBy(xpath = "//div[@class='product-thumb']//h4")
    List<WebElement> linkproductTitle;

    @FindBy(xpath = "//div[@class='product-thumb']//h4//p")
    List<WebElement> linkproductDescription;

    @FindBy(xpath = "//div[@class='product-thumb']//span[contains(@class,'price-new')]")
    List<WebElement> linkProductPrice;

    @FindBy(xpath = "//div[@class='product-thumb']//span[contains(@class,'price-tax')]")
    List<WebElement> linkProductPriceExcludedTax;

    @FindBy(xpath = "//footer//h5[normalize-space()='Information']/following-sibling::ul//li")
    List<WebElement> linkInformationLinks;

    @FindBy(xpath = "//footer//a")
    List<WebElement> linkFooterLinks;

    @FindBy(xpath = "//footer//h5")
    List<WebElement> linkFooterLinksHeaders;

    @FindBy(xpath = "//footer//p")
    List<WebElement> linkFooterFoundation;
    //footer//h5

    public void clickCurrencyDropdown(){
        linkCurrencyDropDown.click();
    }

    public void selectEuroCurrency(){
        linkeuroCurrency.click();
    }

    public void selectPoundCurrency(){
        linkpoundCurrency.click();
    }

    public void selectDollarCurrency(){
        linkdollarCurrency.click();
    }

    public void selectCurrency(String currency){

        clickCurrencyDropdown();

        switch(currency.toLowerCase()){

            case "euro":
                linkeuroCurrency.click();
                break;

            case "pound":
                linkpoundCurrency.click();
                break;

            case "dollar":
                linkdollarCurrency.click();
                break;
        }
    }

    public void enterProductInSearchBox(String product){

        linkSearchBox.sendKeys(product);
    }

    public void clickSearchIcon(){

        linkSearchGlassIcon.click();
    }

    public void searchProduct(String product){

        linkSearchBox.sendKeys(product);
        linkSearchGlassIcon.click();
    }

    public void clickDesktop(){
        linkDesktop.click();
    }

    public void clickComponents(){
        linkComponents.click();
    }

    public void clickMenu(String menu){

        switch(menu.toLowerCase()){

            case "desktop":
                linkDesktop.click();
                break;

            case "components":
                linkComponents.click();
                break;

            case "tablets":
                linkTablets.click();
                break;
        }
    }

    public void printFooterLinks(){
        for(WebElement link : linkFooterLinks){
            System.out.println(link.getText());
        }
    }

    public void clickFooterLink(String linkName){
        for(WebElement link : linkFooterLinks){
            if(link.getText().equalsIgnoreCase(linkName)){
                link.click();
                break;
            }
        }
    }

    public int getFooterLinksCount(){
        return linkFooterLinks.size();
    }

    public int getProductCount(){
        return linkproductTitle.size();
    }

    public void printProductTitles(){
        for(WebElement product : linkproductTitle){
            System.out.println(product.getText());
        }
    }

    public void selectProduct(String productName){
        for(WebElement product : linkproductTitle){
            if(product.getText().equalsIgnoreCase(productName)){
                product.click();
                break;
            }
        }
    }

    public String getPhoneNumber(){
        return linkphoneNumber.getText();
    }

    public String getCartTotal(){
        return linkCartItemTotal.getText();
    }

    public boolean isAppTitleDisplayed(){
        return linkAppTitle.isDisplayed();
    }

    public void printFooterHeaders(){
        for(WebElement header : linkFooterLinksHeaders){
            System.out.println(header.getText());
        }
    }

    public void printFooterFoundationText(){
        for(WebElement text : linkFooterFoundation){
            System.out.println(text.getText());
        }
    }







    public void clickMyAccount(){
        linkMyAccount.click();
    }

    public void clickRegister(){
        linkRegister.click();
    }

    public void clickLogin(){
        linkLogin.click();
    }


}
