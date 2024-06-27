package tests;

import Pages.LandingPage;
import org.testng.annotations.Test;
import testcomponents.BaseTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LaunchLandingPageTest extends BaseTest
{
    @Test
    public void launchURL()
    {
        LandingPage lPage = new LandingPage(driver);
        lPage.navigateToApplications();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lPage.navigateToEditor();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lPage.navigateToSolutions();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lPage.navigateToConnect();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lPage.navigateToAI();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        lPage.navigateToBookDemo();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        lPage.navigateToSignUp();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





    }
}
