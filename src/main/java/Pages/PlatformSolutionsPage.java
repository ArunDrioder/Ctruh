package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformSolutionsPage extends AbstractComponent
{
    WebDriver driver;

    public PlatformSolutionsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[normalize-space()='Connect']")
    WebElement clickToOpenConnectMenu;

    public void verifyCurrentUrl()
    {
        String platformsPage = driver.getCurrentUrl();

    }

    public void mouseHoverToOpenConnectMenu()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(clickToOpenConnectMenu).build().perform();
    }
}
