package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatorsConnectPage extends AbstractComponent
{
    WebDriver driver;

    public CreatorsConnectPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[normalize-space()='Partner with us']")
    WebElement gotoPartnerWithUsPage;





    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String creatorsPageUrl = driver.getCurrentUrl();

    }

    public PartnerWithUsConnectPage goToPartnerWithUsPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(gotoPartnerWithUsPage);
            waitForElementToBeClickable(gotoPartnerWithUsPage);
            gotoPartnerWithUsPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath( "//div[normalize-space()='Partner with us']")));
        }

        Thread.sleep(3000);
        return new PartnerWithUsConnectPage(driver);
    }
}
