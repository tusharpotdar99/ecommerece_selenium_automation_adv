package PageObjects;

import Base.BasePage;
import Components.AccountSidePanelComponent;
import Components.FooterComponent;
import Components.HeaderComponent;
import Components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends BasePage {

    private final HeaderComponent header;
    private final NavigationMenu navigation;
    private final FooterComponent footer;
//    private final BreadcrumbComponent breadcrumb;
    private final AccountSidePanelComponent sidePanel;

    public MyAccountPage(WebDriver driver){
        super(driver);
        header = new HeaderComponent(driver);
        navigation = new NavigationMenu(driver);
        footer = new FooterComponent(driver);
//        breadcrumb = new BreadcrumbComponent(driver);
        sidePanel = new AccountSidePanelComponent(driver);
    }

    private final By myAccountHeading = By.xpath("//h1[normalize-space()='My Account']");
    private final By myAccountHeadingCSS = By.cssSelector("#content h1");

    private final By subHeadings = By.cssSelector("#content h2");
    private final By Links = By.cssSelector("#content ul li");

    public int getLinkCount() {
        return actions.getElementCount(Links);
    }

    public List<WebElement> getLinks(){
        return actions.getElements(Links);
    }

    public void printLinks(){
        for(WebElement link : actions.getElements(Links)){
            System.out.println(link.getText());
        }
    }


    public void clickLink(String linkName){
        for(WebElement link : actions.getElements(Links)){
            if(link.getText().trim().equalsIgnoreCase(linkName)){
                link.click();
                return;
            }
        }
        throw new RuntimeException(
                "Link not found : "+linkName);

    }

    public boolean isLinkDisplayed(String linkName){
        for(WebElement link : actions.getElements(Links)){
            if(link.getText().trim().equalsIgnoreCase(linkName)){
                return link.isDisplayed();
            }
        }
        return false;
    }

    public boolean isLogoutDisplayed(){
        return isLinkDisplayed("Logout");
    }

    public boolean hasLink(String linkName) {

        for (WebElement link : actions.getElements(Links)) {

            if (link.getText().trim().equalsIgnoreCase(linkName)) {
                return true;
            }
        }

        return false;
    }


    public boolean IsMyAccountPageExists(){
        try{
            return (actions.isDisplayed(myAccountHeading));
        }
        catch (Exception e){
            return false;
        }
    }

    public AccountSidePanelComponent sidePanel(){
        return sidePanel;
    }

    public boolean isUserLoggenIn(){
        return actions.isDisplayed(myAccountHeading)
                && sidePanel.isLinkDisplayed("Logout")
                && header.isMyAccoutDisplayed();
    }


}
