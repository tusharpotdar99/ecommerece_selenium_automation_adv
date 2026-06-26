package Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenu  extends BasePage {

    public NavigationMenu(WebDriver driver){
        super(driver);
    }

    private final By desktops = By.linkText("Desktops");
    private final By components = By.linkText("Components");
    private final By tablets = By.linkText("Tablets");
    private final By software = By.linkText("Software");
    private final By phones = By.linkText("Phones & PDAs");
    private final By cameras = By.linkText("Cameras");
    private final By mp3Players = By.linkText("MP3 Players");


    public void openMenu(String menu) {

        switch (menu.toLowerCase()) {

            case "desktops":
                actions.click(desktops);
                break;

            case "components":
                actions.click(components);
                break;

            case "tablets":
                actions.click(tablets);
                break;

            case "software":
                actions.click(software);
                break;

            case "phones":
                actions.click(phones);
                break;

            case "cameras":
                actions.click(cameras);
                break;

            case "mp3":
                actions.click(mp3Players);
                break;

            default:
                throw new IllegalArgumentException("Invalid menu : " + menu);
        }
    }


}
