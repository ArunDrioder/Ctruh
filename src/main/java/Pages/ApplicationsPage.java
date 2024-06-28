package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ApplicationsPage extends AbstractComponent {
    WebDriver driver;

    public ApplicationsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space()='Editor']")
    WebElement goToEditorPage;


    public void verifyCurrentUrl() {
        String applicationPageUrl = driver.getCurrentUrl();


    }

    public EditorPage goToEditorPage() throws InterruptedException {
        try {
            waitForElementToBeVisible(goToEditorPage);
            waitForElementToBeClickable(goToEditorPage);
            goToEditorPage.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[normalize-space()='Editor']")));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.ctruh.com/editor"));
        }

        return new EditorPage(driver);
    }

}
