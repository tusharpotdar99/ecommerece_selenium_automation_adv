package Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterComponent extends BasePage {

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    private final By footerLinks = By.xpath("//footer//a");
    private final By footerHeaders = By.xpath("//footer//h5");
    private final By footerText = By.xpath("//footer//p");

    public int getFooterLinksCount() {
        return actions.getElementCount(footerLinks);
    }

    public void printFooterLinks() {

        List<WebElement> links = actions.getElements(footerLinks);

        for (WebElement link : links) {
            System.out.println(link.getText());
        }
    }

    public void clickFooterLink(String linkName) {

        List<WebElement> links = actions.getElements(footerLinks);

        for (WebElement link : links) {

            if (link.getText().equalsIgnoreCase(linkName)) {
                link.click();
                break;
            }
        }
    }

    public void printFooterHeaders() {

        for (WebElement header : actions.getElements(footerHeaders)) {
            System.out.println(header.getText());
        }
    }

    public void printFooterText() {

        for (WebElement text : actions.getElements(footerText)) {
            System.out.println(text.getText());
        }
    }
}