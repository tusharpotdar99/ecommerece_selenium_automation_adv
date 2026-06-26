package PageObjects;

import Base.BasePage;
import Components.*;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final HeaderComponent header;
    private final NavigationMenu navigation;
    private final CurrencyComponent currency;
    private final ProductGridComponent products;
    private final FooterComponent footer;

    public HomePage(WebDriver driver){

        super(driver);
        header = new HeaderComponent(driver);
        navigation = new NavigationMenu(driver);
        currency = new CurrencyComponent(driver);
        products = new ProductGridComponent(driver);
        footer = new FooterComponent(driver);
    }

    public HeaderComponent header() {
        return header;
    }

    public NavigationMenu navigation() {
        return navigation;
    }

    public CurrencyComponent currency() {
        return currency;
    }

    public ProductGridComponent products() {
        return products;
    }

    public FooterComponent footer() {
        return footer;
    }









}
