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

public class EditorPage extends AbstractComponent
{

    WebDriver driver;

    public EditorPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[normalize-space()='Solutions']")
    WebElement clickToOpenSolutionsMenu;

    @FindBy (xpath = "//div[normalize-space()='MaaS']")
    WebElement goToMaasSolutionsPage;

    public void verifyCurrentUrl()
    {
        String editorPageUrl = driver.getCurrentUrl();

    }

   public void mouHoverToOpenSolutionMenu()
   {
       Actions actions = new Actions(driver);
       actions.moveToElement(clickToOpenSolutionsMenu).build().perform();
   }

   public MaasSolutionsPage goToMaasSolutionsPage()
    {
        try {
            waitForElementToBeVisible(goToMaasSolutionsPage);
            waitForElementToBeClickable(goToMaasSolutionsPage);
            goToMaasSolutionsPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='MaaS']")));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.ctruh.com/solutions/metaverse-as-a-service"));
        }


        return new MaasSolutionsPage(driver);
    }
}
