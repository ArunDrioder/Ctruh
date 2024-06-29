package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookADemoPage extends AbstractComponent
{
    WebDriver driver;

    public BookADemoPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyCurrentUrl(String url) throws InterruptedException {
        waitForUrl(url);
        String demoPageUrl = driver.getCurrentUrl();
    }
}
