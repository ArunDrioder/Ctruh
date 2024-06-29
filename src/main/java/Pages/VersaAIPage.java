package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VersaAIPage extends AbstractComponent
{
    WebDriver driver;

    public VersaAIPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//button[@class='primarySM']")
    WebElement goToDemoPage;

    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String versaAIPageUrl = driver.getCurrentUrl();

    }

    public BookADemoPage goToDemoPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToDemoPage);
            waitForElementToBeClickable(goToDemoPage);
            goToDemoPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='primarySM']")));
        }

        Thread.sleep(3000);

        return new BookADemoPage(driver);

    }
}
