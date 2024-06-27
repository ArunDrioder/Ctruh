package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponent
{


    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;

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


    public void goTo()
    {
        driver.get("https://www.ctruh.com/home");
    }

    public void navigateToApplications()
    {
        goToApplicationPage.click();
    }

    public void navigateToEditor()
    {
        goToEditorPage.click();
    }

    public void navigateToSolutions()
    {
        goToSolutionsPage.click();
    }

    public void navigateToConnect()
    {
        goToConnectPage.click();
    }

    public void navigateToAI()
    {
        goToAIPage.click();
    }

    public void navigateToSignUp()
    {
        goToSignUpPage.click();
    }

    public void navigateToBookDemo()
    {
        goToBookADemoPage.click();
    }


}
