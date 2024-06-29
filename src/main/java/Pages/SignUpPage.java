package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractComponent
{
    WebDriver driver;

    public SignUpPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//button[@class='primarySM']")
    WebElement moveToSignUpForm;

    @FindBy(name = "userName")
    WebElement userName;

    @FindBy(name = "email_id")
    WebElement userEmail;

    @FindBy(name = "password")
    WebElement userPassword;

    @FindBy(xpath = "//input[@class='form-control ']")
    WebElement userMobile;

    @FindBy(css = "label[for='checkBox']")
    WebElement agreeCheckClick;

    @FindBy(xpath = "//button[@class='primarySM']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement roboCheckBox;

    @FindBy(xpath = "//h2[normalize-space()='Verify Yourself']")
    WebElement verifyOTPTitle;

    @FindBy(xpath = "//button[normalize-space()='VERIFY']")
    WebElement verifyOTPButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement roboCheckBoxOtp;




    public void createNewAccount(String name, String email, String password, String mobileNo) throws InterruptedException
    {
        Thread.sleep(3000);
        moveToSignUpForm.click();
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        userMobile.sendKeys(mobileNo);
        agreeCheckClick.click();
        signUpButton.click();




    }
}


