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

    @FindBy(xpath = "//button[@class='secondarySM text-[--white-color]']")
    WebElement goToSignUpPage;

    public void goTo()
    {
        driver.get("https://www.ctruh.com/home");
    }

    public void verifyCurrentUrl()
    {
       String landingPageUrl = driver.getCurrentUrl();
        System.out.println(landingPageUrl);
    }

    public ApplicationsPage gotoApplicationsPage() throws InterruptedException {

        goToApplicationPage.click();
        Thread.sleep(3000);
        return new ApplicationsPage(driver);
    }


public SignUpPage goToSignUpPage()
{
    goToSignUpPage.click();

    return new SignUpPage(driver);
}


}
