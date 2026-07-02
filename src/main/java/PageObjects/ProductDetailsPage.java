package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
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


    private final By  labelProductName=  By.xpath("//div[@id='content']//h1");
    private final By  labelBrandName=  By.xpath("(//div[@id='content']//li)[1]");
    private final By  labelProductCode=  By.xpath("(//div[@id='content']//li)[2]");
    private final By  labelRewardPoints=  By.xpath("(//div[@id='content']//li)[3]");
    private final By  labelProductStockAvailability=  By.xpath("(//div[@id='content']//li)[4]");
    private final By  labelReviews=  By.xpath("//div[@class='rating']//a[1]");
    private final By linkWriteReview =  By.xpath("//div[@class='rating']//a[2]");
    private final By labelProductPrice =  By.xpath("//span[@class='price-new']");
    private final By labelProductPriceExcludedTax =  By.xpath("//li[contains(text(),'Ex Tax')]");
    private final By buttonAddToWishList =  By.xpath("//button[@aria-label='Add to Wish List']");
    private final By buttonCompareProduct  =  By.xpath("//button[@title='Compare this Product']");
    private final By textProductQuantity =  By.xpath("//input[@id='input-quantity']");
    private final By buttonAddtoCart =  By.xpath("//button[@id='button-cart']");
    private final By imageProductImage =  By.xpath("(//div[@class='image magnific-popup']//a//img)[1]");
    private final By imageProductSV =  By.xpath("//div[@class='image magnific-popup']//div//a");
    private final By labelDescriptionNav =  By.xpath("//a[normalize-space()='Description']");
    private final By labelSpecificationNav =  By.xpath("//a[normalize-space()='Specification']");
    private final By labelReviewNav =  By.xpath("//a[contains(normalize-space(),'Reviews')]");
    private final By descriptionTexts =  By.xpath("//div[@id='tab-description']");
    private final By specificationText =  By.xpath("//div[@id='tab-specification']");
    private final By textReviewerName =  By.xpath("//input[@id='input-author']");
    private final By textAreaReview =  By.xpath("//textarea[@id='input-text']");
    private final By radioRating =  By.xpath("//div[@id='input-rating']//input[@type='radio']");
    private final By buttonReview =  By.xpath("//button[@id='button-review']");

    public boolean isProductPageDisplayed(){
        return actions.isDisplayed(labelProductName);
    }

    public boolean isReviewTabDisplayed(){
        return actions.isDisplayed(labelReviewNav);
    }

    public void clickProductImage(){
        actions.click(imageProductImage);
    }

    public String DescriptionText(){
        actions.click(labelDescriptionNav);
        return actions.getText(descriptionTexts);
    }

    public String SpecificationText(){
        actions.click(labelSpecificationNav);
        return actions.getText(specificationText);
    }



    public void productInformation(){
        actions.getText(labelProductName);
        actions.getText(labelBrandName);
        actions.getText(labelRewardPoints);
        actions.getText(labelProductStockAvailability);
        actions.getText(labelProductPrice);
        actions.getText(labelProductPriceExcludedTax);
    }

    public void addToCart(){
        actions.click(buttonAddtoCart);
    }

    public void addToWishList(){
        actions.click(buttonAddToWishList);
    }

    public void CompareProductPage(){
        actions.click(buttonCompareProduct);
    }

    public void enterProductQuantity(String quantity){
        actions.type(textProductQuantity, quantity);
    }

    public void addProductToCart(String quantity){
        enterProductQuantity(quantity);
        addToCart();
    }

    public boolean isProductImageDisplayed(){
        return actions.isDisplayed(imageProductImage);
    }




    public void submitReview(
            String reviewerName,
            String reviewText,
            String rating){

        actions.click(labelReviewNav);
        actions.type(textReviewerName, reviewerName);
        actions.type(textAreaReview, reviewText);
        actions.selectByVisibleText(radioRating, rating);
        actions.click(buttonReview);
    }












}
