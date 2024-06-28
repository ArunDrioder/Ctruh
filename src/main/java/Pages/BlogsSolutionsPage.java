package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogsSolutionsPage extends AbstractComponent
{
    WebDriver driver;

    public BlogsSolutionsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[normalize-space()='Platform']")
    WebElement goToPlatformPage;



    public void verifyCurrentUrl()
    {
        String blogsPageUrl = driver.getCurrentUrl();

    }

    public PlatformSolutionsPage goToPlaformsPage()
    {
        try {
            waitForElementToBeVisible(goToPlatformPage);
            waitForElementToBeClickable(goToPlatformPage);
            goToPlatformPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Platform']")));
        }
        return new PlatformSolutionsPage(driver);

    }
}
