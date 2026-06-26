package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "(//ul[@class='breadcrumb']//li//a)[2]")
    WebElement breadcrumbProduct;

    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement labelProductName;

    @FindBy(xpath = "(//div[@id='content']//li)[1]")
    WebElement labelBrandName;

    @FindBy(xpath = "(//div[@id='content']//li)[2]")
    WebElement labelProductCode;

    @FindBy(xpath = "(//div[@id='content']//li)[3]")
    WebElement labelRewardPoints;

    @FindBy(xpath = "(//div[@id='content']//li)[4]")
    WebElement labelProductStockAvailability;

    @FindBy(xpath = "//div[@class='rating']//a[1]")
    WebElement labelReviews;

    @FindBy(xpath = "//div[@class='rating']//a[2]")
    WebElement linkWriteReview;

    @FindBy(xpath = "//span[@class='price-new']")
    WebElement labelProductPrice;

    @FindBy(xpath = "//li[contains(text(),'Ex Tax')]")
    WebElement labelProductPriceExcludedTax;

    @FindBy(xpath = "//button[@aria-label='Add to Wish List']")
    WebElement buttonAddToWishList;

    @FindBy(xpath = "//button[@title='Compare this Product']")
    WebElement buttonCompareProduct;

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement textProductQuantity;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement buttonAddtoCart;

    @FindBy(xpath = "(//div[@class='image magnific-popup']//a//img)[1]")
//    @FindBy(css = ".image.magnific-popup img")
    WebElement imageProductImage;

    @FindBy(xpath = "//div[@class='image magnific-popup']//div//a")
    WebElement imageProductSV;

    @FindBy(xpath = "//a[normalize-space()='Description']")
    WebElement labelDescriptionNav;

    @FindBy(xpath = "//a[normalize-space()='Specification']")
    WebElement labelSpecificationNav;

    @FindBy(xpath = "//a[contains(normalize-space(),'Reviews')]")
    WebElement labelReviewNav;

    @FindBy(xpath = "//div[@id='tab-description']")
    WebElement descriptionTexts;

    @FindBy(xpath = "//div[@id='tab-specification']")
    WebElement specificationText;

    @FindBy(xpath = "//input[@id='input-author']")
    WebElement textReviewerName;

    @FindBy(xpath = "//textarea[@id='input-text']")
    WebElement textAreaReview;

    @FindBy(xpath = "//div[@id='input-rating']//input[@type='radio']")
    List<WebElement> radioRating;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement buttonReview;

    public String getProductName(){
        return labelProductName.getText();
    }

    public String getBrandName(){
        return labelBrandName.getText();
    }

    public String getRewardPoints(){
        return labelRewardPoints.getText();
    }

    public String getStockAvailability(){
        return labelProductStockAvailability.getText();
    }

    public String getProductPrice(){
        return labelProductPrice.getText();
    }

    public String getExcludedTaxPrice(){
        return labelProductPriceExcludedTax.getText();
    }

    public void clickAddToWishList(){
        buttonAddToWishList.click();
    }

    public void clickCompareProduct(){
        buttonCompareProduct.click();
    }

    public void enterProductQuantity(String quantity){
        textProductQuantity.clear();
        textProductQuantity.sendKeys(quantity);
    }

    public void clickAddToCart(){
        buttonAddtoCart.click();
    }

    public void addProductToCart(String quantity){
        enterProductQuantity(quantity);
        clickAddToCart();
    }

    public boolean isProductImageDisplayed(){
        return imageProductImage.isDisplayed();
    }

    public void clickProductImage(){
        imageProductImage.click();
    }

    public void clickDescriptionTab(){
        labelDescriptionNav.click();
    }

    public void clickSpecificationTab(){
        labelSpecificationNav.click();
    }

    public void clickReviewTab(){
        labelReviewNav.click();
    }

    public String getDescriptionText(){
        return descriptionTexts.getText();
    }

    public String getSpecificationText(){
        return specificationText.getText();
    }

    public void enterReviewerName(String name){
        textReviewerName.sendKeys(name);
    }

    public void enterReviewText(String review){
        textAreaReview.sendKeys(review);
    }

    public void selectRating(int rating){
        radioRating.get(rating - 1).click();
    }

    public void clickReviewButton(){
        buttonReview.click();
    }

    public void submitReview(
            String reviewerName,
            String reviewText,
            int rating){

        clickReviewTab();

        enterReviewerName(reviewerName);

        enterReviewText(reviewText);

        selectRating(rating);

        clickReviewButton();
    }

    public boolean isProductPageDisplayed(){
        return labelProductName.isDisplayed();
    }

    public boolean isReviewTabDisplayed(){
        return labelReviewNav.isDisplayed();
    }

    public String getBreadcrumbText(){
        return breadcrumb.getText();
    }










}
