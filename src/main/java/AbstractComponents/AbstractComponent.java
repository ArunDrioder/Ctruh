package AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class AbstractComponent
{
    WebDriver driver;


    public AbstractComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }



    @FindBy(xpath = "//div[normalize-space()='Applications']")
    WebElement goToApplicationPage;

    @FindBy(xpath = "//div[normalize-space()='Editor']")
    WebElement goToEditorPage;

    @FindBy(xpath = "//div[normalize-space()='Solutions']")
    WebElement goToSolutionsPage;

    @FindBy(xpath = "//div[normalize-space()='Connect']")
    WebElement goToConnectPage;

    @FindBy(xpath = "//span[normalize-space()='AI']")
    WebElement goToAIPage;

    @FindBy(xpath = "//button[@class = 'secondarySM text-[--white-color]']")
    WebElement goToSignUpPage;

    @FindBy(xpath = "//button[@class = 'primarySM']")
    WebElement goToBookADemoPage;


    public void waitForElementToBeVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



public void waitForElementToBeClickable(WebElement element)
{
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void waitForUrl(String url)
{
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(url));
}








}
