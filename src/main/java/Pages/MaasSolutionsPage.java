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

public class MaasSolutionsPage extends AbstractComponent {
    WebDriver driver;

    public MaasSolutionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Solutions']")
    WebElement clickToOpenSolutionsMenu;

    @FindBy(xpath = "//div[normalize-space()='Resources']")
    WebElement goToResourcesSolutionsPage;

    @FindBy(xpath = "//div[normalize-space()='Blogs']")
    WebElement gotoBlogsSolutionsPage;

    public void verifyCurrentUrl() {
        String maasPageUrl = driver.getCurrentUrl();

    }

    public void mouseHoverToOpenSolutionMenu()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(clickToOpenSolutionsMenu).build().perform();
    }




    public ResourcesSolutionsPage goToResourcesSolutionsPage() {
        try {
            waitForElementToBeVisible(goToResourcesSolutionsPage);
            waitForElementToBeClickable(goToResourcesSolutionsPage);
            goToResourcesSolutionsPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Resources']")));
        }
        return new ResourcesSolutionsPage(driver);
    }

    public BlogsSolutionsPage goToBlogsSolutionsPage()
    {
        try {
            waitForElementToBeVisible(gotoBlogsSolutionsPage);
            waitForElementToBeClickable(gotoBlogsSolutionsPage);
            gotoBlogsSolutionsPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Blogs']")));
        }
        return new BlogsSolutionsPage(driver);

    }
}
