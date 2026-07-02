package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class OrdersPage extends BasePage {

    public OrdersPage(WebDriver driver){
        super(driver);
    }

    private final By labelOrdersPage = By.xpath("//h1[normalize-space()='Orders']");
    private final By tableHeaders = By.xpath("//table//thead//th");
    private final By allOrders  = By.xpath("//table//tbody//tr");
    private final By linkProductDetails  = By.xpath("//i[@class='fa-solid fa-eye']");
    private final By labelPaginationInfo  = By.xpath("//div[contains(text(),'Showing')]");
    private final By buttonContinue = By.xpath("//a[normalize-space()='Continue']");
    private final By labelOrderId = By.xpath("//table//tbody//tr[1]//td[1]");
    private final By labelNoOfProducts = By.xpath("//table//tbody//tr[1]//td[2]");
    private final By labelOrderStatus  = By.xpath("//table//tbody//tr[1]//td[3]");
    private final By labelOrderTotal = By.xpath("//table//tbody//tr[1]//td[4]");
    private final By labelDateAdded  = By.xpath("//table//tbody//tr[1]//td[5]");
    private final By buttonViewOrder = By.xpath("//table//tbody//tr[1]//td[6]//a");


    public boolean isOrdersPageDisplayed(){
        return actions.isDisplayed(labelOrdersPage);
    }

    public String getOrdersPageHeading(){
        return actions.getText(labelOrdersPage);
    }

    public int getOrdersCount(){
        return actions.getElementCount(allOrders);
    }


    public void printTableHeaders(){
        List<WebElement> headers= actions.getElements(tableHeaders);
        for(WebElement header : headers){
            System.out.println(header.getText());
        }
    }

    // Order Detail Methods
    public void orderDetails(){
        String orderId = actions.getText(labelOrderId);
        String orderStatus = actions.getText(labelOrderStatus);
        String orderTotal = actions.getText(labelOrderTotal);
        String dataAdded = actions.getText(labelDateAdded);
    }

    // View Order Methods

    public void clickViewOrder(){
        actions.click(buttonViewOrder);
    }

    public String getPaginationInfo(){
        return actions.getText(labelPaginationInfo);
    }

    public void clickContinue(){
        actions.click(buttonContinue);
    }




}
