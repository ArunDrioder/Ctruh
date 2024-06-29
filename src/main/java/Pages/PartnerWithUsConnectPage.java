package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnerWithUsConnectPage extends AbstractComponent
{
    WebDriver driver;

    public PartnerWithUsConnectPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//div[normalize-space()='Connect']")
    WebElement clickToOpenConnectMenu;

    @FindBy(xpath = "//div[normalize-space()='Careers']")
    WebElement goToCareersPage;

    @FindBy(xpath = "//div[normalize-space()='Contact us']")
    WebElement goToContactUsPage;

    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String partnersPage = driver.getCurrentUrl();

    }

    public void mouseHoverToOpenConnectMenu()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(clickToOpenConnectMenu).build().perform();
    }

    public CareersConnectPage gotoCareersConnectPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToCareersPage);
            waitForElementToBeClickable(goToCareersPage);
            goToCareersPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Careers']")));
        }

        Thread.sleep(3000);
        return new CareersConnectPage(driver);

    }

    public ContactUsConnectPage goToContactUsConnectPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToContactUsPage);
            waitForElementToBeClickable(goToContactUsPage);
            goToContactUsPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Contact us']")));
        }
        Thread.sleep(3000);
        return new ContactUsConnectPage(driver);

    }


}
