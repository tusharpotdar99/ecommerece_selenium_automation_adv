package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends BasePage {

    WebDriver driver;
    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']")
    WebElement breadcrumb;

    @FindBy(xpath = "//ul[@class='breadcrumb']//a[contains(text(),'Orders')]")
    WebElement breadcrumbOrders;

    @FindBy(xpath = "//h1[normalize-space()='Orders']")
    WebElement labelOrdersPage;

    @FindBy(xpath = "//table//thead//th")
    List<WebElement> tableHeaders;

    @FindBy(xpath = "//table//tbody//tr")
    List<WebElement> allOrders;

    @FindBy(xpath = "//i[@class='fa-solid fa-eye']")
    WebElement linkProductDetails;

    @FindBy(xpath = "//div[contains(text(),'Showing')]")
    WebElement labelPaginationInfo;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement buttonContinue;


    @FindBy(xpath = "//table//tbody//tr[1]//td[1]")
    WebElement labelOrderId;

    @FindBy(xpath = "//table//tbody//tr[1]//td[2]")
    WebElement labelNoOfProducts;

    @FindBy(xpath = "//table//tbody//tr[1]//td[3]")
    WebElement labelOrderStatus;

    @FindBy(xpath = "//table//tbody//tr[1]//td[4]")
    WebElement labelOrderTotal;

    @FindBy(xpath = "//table//tbody//tr[1]//td[5]")
    WebElement labelDateAdded;

    @FindBy(xpath = "//table//tbody//tr[1]//td[6]//a")
    WebElement buttonViewOrder;

    public boolean isOrdersPageDisplayed(){

        return labelOrdersPage.isDisplayed();
    }

    public String getBreadcrumbText(){

        return breadcrumb.getText();
    }

    public String getOrdersPageHeading(){

        return labelOrdersPage.getText();
    }

    public int getOrdersCount(){

        return allOrders.size();
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
    // Order Detail Methods
    // ==========================

    public String getOrderId(){

        return labelOrderId.getText();
    }

    public String getNoOfProducts(){

        return labelNoOfProducts.getText();
    }

    public String getOrderStatus(){

        return labelOrderStatus.getText();
    }

    public String getOrderTotal(){

        return labelOrderTotal.getText();
    }

    public String getDateAdded(){

        return labelDateAdded.getText();
    }





    // ==========================
    // View Order Methods
    // ==========================

    public void clickViewOrder(){
        buttonViewOrder.click();
    }

    public String getPaginationInfo(){
        return labelPaginationInfo.getText();
    }

    public void clickContinue(){
        buttonContinue.click();
    }




}
