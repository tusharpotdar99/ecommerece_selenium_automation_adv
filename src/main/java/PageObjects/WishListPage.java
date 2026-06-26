package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h1")
    WebElement labelMyWishlist;

    @FindBy(xpath = "//button[normalize-space()='Add to Cart']")
    WebElement buttonAddTocart;

    @FindBy(xpath = "//a[normalize-space()='Remove']")
    WebElement buttonRemove;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement buttonContinue;

    @FindBy(xpath = "//table//thead//th")
    List<WebElement> tableHeaders;

    @FindBy(xpath = "//table//tbody//tr")
    List<WebElement> tableRowsOrders;

    @FindBy(xpath = "//table//tbody//tr//td[1]//img")
    WebElement imgProduct;

    @FindBy(xpath = "//table//tbody//tr//td[2]")
    WebElement labelProductName;

    @FindBy(xpath = "//table//tbody//tr//td[3]")
    WebElement labelModel;

    @FindBy(xpath = "//table//tbody//tr//td[4]")
    WebElement labelStock;

    @FindBy(xpath = "//table//tbody//tr//td[5]")
    WebElement labelUnitPrice;

    public boolean isWishListPageDisplayed(){

        return labelMyWishlist.isDisplayed();
    }

    public String getWishListPageHeading(){

        return labelMyWishlist.getText();
    }

    public int getWishListProductsCount(){

        return tableRowsOrders.size();
    }

    public boolean isProductImageDisplayed(){

        return imgProduct.isDisplayed();
    }





    // ==========================
    // Product Detail Methods
    // ==========================

    public String getProductName(){

        return labelProductName.getText();
    }

    public String getProductModel(){

        return labelModel.getText();
    }

    public String getProductStock(){

        return labelStock.getText();
    }

    public String getProductUnitPrice(){

        return labelUnitPrice.getText();
    }





    // ==========================
    // Table Header Methods
    // ==========================

    public void printTableHeaders(){

        for(WebElement header : tableHeaders){

            System.out.println(header.getText());
        }
    }





    // ==========================
    // Button Action Methods
    // ==========================

    public void clickAddToCart(){

        buttonAddTocart.click();
    }

    public void clickRemove(){

        buttonRemove.click();
    }

    public void clickContinue(){

        buttonContinue.click();
    }





    // ==========================
    // Complete Wishlist Flow
    // ==========================

    public void moveProductToCart(){

        clickAddToCart();
    }

    public void removeProductFromWishList(){

        clickRemove();
    }



}
