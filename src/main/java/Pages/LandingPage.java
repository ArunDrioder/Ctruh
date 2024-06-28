package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent
{
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[normalize-space()='Applications']")
    WebElement goToApplicationPage;

    public void goTo()
    {
        driver.get("https://www.ctruh.com/home");
    }

    public void verifyCurrentUrl()
    {
       String landingPageUrl = driver.getCurrentUrl();
        System.out.println(landingPageUrl);
    }

    public ApplicationsPage gotoApplicationsPage()
    {
        goToApplicationPage.click();
        return new ApplicationsPage(driver);
    }


//
//
//    public void navigateToApplications(String url)
//    {
//        goToApplicationPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToEditor(String url)
//    {
//        goToEditorPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToSolutions(String url)
//    {
//        goToSolutionsPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToConnect(String url)
//    {
//        goToConnectPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToAI(String url)
//    {
//        goToAIPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToSignUp(String url)
//    {
//        goToSignUpPage.click();
//        waitForUrlChange(url);
//    }
//
//    public void navigateToBookDemo(String url)
//    {
//        goToBookADemoPage.click();
//        waitForUrlChange(url);
//    }


}
