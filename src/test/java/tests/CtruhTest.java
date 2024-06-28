package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcomponents.BaseTest;

import java.util.concurrent.TimeUnit;

public class CtruhTest extends BaseTest {
    @Test
    public void verifyHeaderNavigation() throws InterruptedException {
        LandingPage lPage = new LandingPage(driver);
        lPage.goTo();
        lPage.verifyCurrentUrl();
        String actualHomeUrl = driver.getCurrentUrl();
        String expectedHomeUrl = getProperty("homeUrl");
        Assert.assertEquals(actualHomeUrl, expectedHomeUrl);
        ApplicationsPage applicationsPage = lPage.gotoApplicationsPage();
        applicationsPage.verifyCurrentUrl();
        String actualApplicationPageUrl = driver.getCurrentUrl();
        String expectedApplicationPageUrl = getProperty("applicationsPageUrl");
        Assert.assertEquals(actualApplicationPageUrl, expectedApplicationPageUrl);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        EditorPage editorPage = applicationsPage.goToEditorPage();
        System.out.println("Editor Menu Clicked");
        editorPage.verifyCurrentUrl();
        System.out.println("Editor page Url verified");
        String actualEditorPageUrl = driver.getCurrentUrl();
        String expectedEditorPageUrl = getProperty("editorPageUrl");
        Assert.assertEquals(actualEditorPageUrl, expectedEditorPageUrl);
        editorPage.mouHoverToOpenSolutionMenu();
        MaasSolutionsPage maasSolutionsPage = editorPage.goToMaasSolutionsPage();
        maasSolutionsPage.verifyCurrentUrl();
        System.out.println("Maas page Url verified");
        String expectedMaasPageUrl = driver.getCurrentUrl();
        String actualMaasPageUrl = getProperty("solutionMetaverseUrl");
        Assert.assertEquals(actualMaasPageUrl,expectedMaasPageUrl);
        ResourcesSolutionsPage resourcesSolutionsPage = maasSolutionsPage.goToResourcesSolutionsPage();
        resourcesSolutionsPage.verifyCurrentUrl();
        driver.navigate().refresh();
        //Thread.sleep(3000);
        maasSolutionsPage.mouseHoverToOpenSolutionMenu();
        BlogsSolutionsPage blogsSolutionsPage  = maasSolutionsPage.goToBlogsSolutionsPage();
        blogsSolutionsPage.verifyCurrentUrl();
        String actualBlogsSolutionsPageUrl = driver.getCurrentUrl();
        String expectedBlogsSolutionsPageUrl = getProperty("solutionBlogsUrl");
        Assert.assertEquals(actualBlogsSolutionsPageUrl,expectedBlogsSolutionsPageUrl);
        PlatformSolutionsPage platformSolutionsPage = blogsSolutionsPage.goToPlaformsPage();
        platformSolutionsPage.verifyCurrentUrl();
        String actualPlatformSolutionsPageUrl = driver.getCurrentUrl();
        String expectedPlatformSolutionsPageUrl = getProperty("solutionPlatformUrl");
        Assert.assertEquals(actualPlatformSolutionsPageUrl,expectedPlatformSolutionsPageUrl);
        platformSolutionsPage.mouseHoverToOpenConnectMenu();
    }
}
