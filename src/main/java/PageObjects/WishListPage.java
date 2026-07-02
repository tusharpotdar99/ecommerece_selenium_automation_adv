package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver){super(driver);}

    private final By labelMyWishlist = By.xpath("//h1");
    private final By buttonAddTocart = By.xpath("//button[normalize-space()='Add to Cart']");
    private final By buttonRemove = By.xpath("//a[normalize-space()='Remove']");
    private final By buttonContinue  = By.xpath("//a[normalize-space()='Continue']");
    private final By tableHeaders = By.xpath("//table//thead//th");
    private final By tableRowsOrders = By.xpath("//table//tbody//tr");
    private final By imgProduct  = By.xpath("//table//tbody//tr//td[1]//img");
    private final By labelProductName = By.xpath("//table//tbody//tr//td[2]");
    private final By labelModel = By.xpath("//table//tbody//tr//td[3]");
    private final By labelStock  = By.xpath("//table//tbody//tr//td[4]");
    private final By labelUnitPrice = By.xpath("//table//tbody//tr//td[5]");
    
    public boolean isWishListPageDisplayed(){

        return actions.isDisplayed(labelMyWishlist);
    }

    public String getWishListPageHeading(){

        return actions.getText(labelMyWishlist);
    }

    public int getWishListProductsCount(){

        return actions.getElementCount(tableRowsOrders);
    }

    public boolean isProductImageDisplayed(){

        return actions.isDisplayed(imgProduct);
    }

    public String getProductName(){

        return actions.getText(labelProductName);
    }

    public String getProductModel(){

        return actions.getText(labelModel);
    }

    public String getProductStock(){

        return actions.getText(labelStock);
    }

    public String getProductUnitPrice(){

        return actions.getText(labelUnitPrice);
    }


    public void printTableHeaders(){

        List<WebElement> headers = actions.getElements(tableHeaders);

        for(WebElement header : headers){

            System.out.println(header.getText());
        }
    }





    // ==========================
    // Button Action Methods
    // ==========================
//
//    public void clickAddToCart(){
//
//        buttonAddTocart.click();
//    }
//
//    public void clickRemove(){
//
//        buttonRemove.click();
//    }
//
//    public void clickContinue(){
//
//        buttonContinue.click();
//    }





    // ==========================
    // Complete Wishlist Flow
    // ==========================

//    public void moveProductToCart(){
//
//        clickAddToCart();
//    }
//
//    public void removeProductFromWishList(){
//
//        clickRemove();
//    }



}
