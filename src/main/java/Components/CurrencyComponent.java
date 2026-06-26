package Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrencyComponent extends BasePage {

    public CurrencyComponent(WebDriver driver){
        super(driver);
    }

    private final By currencyDropdown = By.xpath("//strong[normalize-space()='$']");
    private final By euro = By.xpath("//button[contains(text(),'€Euro')]");
    private final By pound = By.xpath("//button[normalize-space()='£Pound Sterling']");
    private final By dollar = By.xpath("//button[normalize-space()='$US Dollar']");

    public void selectCurrency(String currency) {

        actions.click(currencyDropdown);

        switch (currency.toLowerCase()) {

            case "euro":
                actions.click(euro);
                break;

            case "pound":
                actions.click(pound);
                break;

            case "dollar":
                actions.click(dollar);
                break;

            default:
                throw new IllegalArgumentException("Invalid currency : " + currency);
        }
    }




}
