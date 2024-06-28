package Pages;

import AbstractComponents.AbstractComponent;
import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ResourcesSolutionsPage extends AbstractComponent
{
    WebDriver driver;

    public ResourcesSolutionsPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyCurrentUrl()
    {
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

        String resourcePageUrl = driver.getCurrentUrl();
        System.out.println("The resource page Url is" +resourcePageUrl);
        driver.close();
        driver.switchTo().window(originalWindow);

    }


}
