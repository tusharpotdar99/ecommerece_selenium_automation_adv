package Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductGridComponent extends BasePage {

    public ProductGridComponent(WebDriver driver) {
        super(driver);
    }

    private final By productTitles = By.xpath("//div[@class='product-thumb']//h4");

    private final By qaproductTitles = By.xpath("//div[contains(@class,'product-thumb')]//h4//a");
    public int getProductCount() {
        return actions.getElementCount(productTitles);
    }

    public void printProductTitles() {

        List<WebElement> products = actions.getElements(productTitles);

        for (WebElement product : products) {
            System.out.println(product.getText());
        }
    }

    public void selectProduct(String productName) {

        List<WebElement> products = actions.getElements(productTitles);

        for (WebElement product : products) {

            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }
}