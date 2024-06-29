package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsConnectPage extends AbstractComponent
{
    WebDriver driver;

    public ContactUsConnectPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//span[normalize-space()='AI']")
    WebElement goToVersaAIPage;



    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String contactUsPageUrl = driver.getCurrentUrl();

    }

    public VersaAIPage gotoVersaAIPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToVersaAIPage);
            waitForElementToBeClickable(goToVersaAIPage);
            goToVersaAIPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[normalize-space()='AI']")));
        }

        Thread.sleep(3000);
        return new VersaAIPage(driver);

    }
}
