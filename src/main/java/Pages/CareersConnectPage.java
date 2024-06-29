package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CareersConnectPage extends AbstractComponent
{
    WebDriver driver;

    public CareersConnectPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyCurrentUrl() throws InterruptedException {

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        while (allWindows.size() == 1) {
            allWindows = driver.getWindowHandles();
        }

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String careersPageUrl = driver.getCurrentUrl();
        System.out.println("The resource page Url is" +careersPageUrl);
        driver.close();
        driver.switchTo().window(originalWindow);

    }

}
