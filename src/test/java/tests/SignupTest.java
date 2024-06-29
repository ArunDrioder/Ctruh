package tests;

import Pages.SignUpPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SignupTest extends BaseTest
{
    @Test(dataProvider = "getData")
    public void signupAccount(HashMap<String,String> input) throws InterruptedException {
        landingPage.goTo();
        SignUpPage signUpPage = landingPage.goToSignUpPage();
        signUpPage.createNewAccount(input.get("name"),input.get("email"),input.get("password"),input.get("mobileNo"));

    }

    @DataProvider
    public Object [][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//SignUpData.json");
        return new Object[][]  {{data.getFirst()}};
    }
}
