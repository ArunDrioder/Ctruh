package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//div[normalize-space()='Creators of Ctruh']")
    WebElement goToCreatorsConnectPage;

    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String platformsPage = driver.getCurrentUrl();

    }

    public void mouseHoverToOpenConnectMenu()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(clickToOpenConnectMenu).build().perform();
    }

    public CreatorsConnectPage gotoCreatorsConnectPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToCreatorsConnectPage);
            waitForElementToBeClickable(goToCreatorsConnectPage);
            goToCreatorsConnectPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='MaaS']")));

        }

       Thread.sleep(3000);
        return new CreatorsConnectPage(driver);
    }
}
