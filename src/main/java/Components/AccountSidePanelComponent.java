package Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSidePanelComponent extends BasePage {

    public AccountSidePanelComponent(WebDriver driver){ super(driver);}

    private final By sidePanelLinks = By.xpath("//aside//a[@class='list-group-item']");
    private final By sidePanelHeading =
            By.cssSelector(".list-group > a:first-child");

    public int getLinkCount() {
        return actions.getElementCount(sidePanelLinks);
    }

    public List<WebElement> getLinks(){
        return actions.getElements(sidePanelLinks);
    }

    public void printLinks(){
        for(WebElement link : actions.getElements(sidePanelLinks)){
            System.out.println(link.getText());
        }
    }

    public void clickLink(String linkName){
        for(WebElement link : actions.getElements(sidePanelLinks)){
            if(link.getText().trim().equalsIgnoreCase(linkName)){
                link.click();
                return;
            }
        }
        throw new RuntimeException(
                "Link not found : "+linkName);

    }

    public boolean isLinkDisplayed(String linkName){
        for(WebElement link : actions.getElements(sidePanelLinks)){
            if(link.getText().trim().equalsIgnoreCase(linkName)){
                return link.isDisplayed();
            }
        }
        return false;
    }

    public boolean hasLink(String linkName) {

        for (WebElement link : actions.getElements(sidePanelLinks)) {

            if (link.getText().trim().equalsIgnoreCase(linkName)) {
                return true;
            }
        }

        return false;
    }

    public String getHeading() {
        return actions.getText(sidePanelHeading);
    }


}
