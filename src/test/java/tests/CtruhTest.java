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
        String actualApplicationPageUrl = driver.getCurrentUrl();
        String expectedApplicationPageUrl = getProperty("applicationsPageUrl");
        applicationsPage.verifyCurrentUrl(expectedApplicationPageUrl);
        Assert.assertEquals(actualApplicationPageUrl, expectedApplicationPageUrl);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        EditorPage editorPage = applicationsPage.goToEditorPage();
        System.out.println("Editor Menu Clicked");

        System.out.println("Editor page Url verified");
        String actualEditorPageUrl = driver.getCurrentUrl();
        String expectedEditorPageUrl = getProperty("editorPageUrl");
        editorPage.verifyCurrentUrl(expectedEditorPageUrl);
        Assert.assertEquals(actualEditorPageUrl, expectedEditorPageUrl);
        editorPage.mouHoverToOpenSolutionMenu();
        MaasSolutionsPage maasSolutionsPage = editorPage.goToMaasSolutionsPage();

        System.out.println("Maas page Url verified");

        String actualMaasPageUrl = driver.getCurrentUrl();
        String expectedMaasPageUrl = getProperty("solutionMetaverseUrl");
        maasSolutionsPage.verifyCurrentUrl(expectedMaasPageUrl);
        Assert.assertEquals(actualMaasPageUrl,expectedMaasPageUrl);
        ResourcesSolutionsPage resourcesSolutionsPage = maasSolutionsPage.goToResourcesSolutionsPage();
        resourcesSolutionsPage.verifyCurrentUrl();
        driver.navigate().refresh();
        maasSolutionsPage.mouseHoverToOpenSolutionMenu();
        BlogsSolutionsPage blogsSolutionsPage  = maasSolutionsPage.goToBlogsSolutionsPage();

        String actualBlogsSolutionsPageUrl = driver.getCurrentUrl();
        String expectedBlogsSolutionsPageUrl = getProperty("solutionBlogsUrl");
        blogsSolutionsPage.verifyCurrentUrl(expectedBlogsSolutionsPageUrl);
        Assert.assertEquals(actualBlogsSolutionsPageUrl,expectedBlogsSolutionsPageUrl);
        PlatformSolutionsPage platformSolutionsPage = blogsSolutionsPage.goToPlaformsPage();

        String actualPlatformSolutionsPageUrl = driver.getCurrentUrl();
        String expectedPlatformSolutionsPageUrl = getProperty("solutionPlatformUrl");
        platformSolutionsPage.verifyCurrentUrl(expectedPlatformSolutionsPageUrl);
        Assert.assertEquals(actualPlatformSolutionsPageUrl,expectedPlatformSolutionsPageUrl);
        platformSolutionsPage.mouseHoverToOpenConnectMenu();
        CreatorsConnectPage creatorsConnectPage = platformSolutionsPage.gotoCreatorsConnectPage();

        String actualCCPageUrl = driver.getCurrentUrl();
        String expectedCCPageUrl = getProperty("connectAboutUs");
        creatorsConnectPage.verifyCurrentUrl(expectedCCPageUrl);
        Assert.assertEquals(actualCCPageUrl,expectedCCPageUrl);
        PartnerWithUsConnectPage partnerPage = creatorsConnectPage.goToPartnerWithUsPage();

        String actualPartnerUrl = driver.getCurrentUrl();
        String expectedPartnerUrl = getProperty("connectPartnerWithUs");
        partnerPage.verifyCurrentUrl(expectedPartnerUrl);
        Assert.assertEquals(actualPartnerUrl,expectedPartnerUrl);
        CareersConnectPage ccPage = partnerPage.gotoCareersConnectPage();
        ccPage.verifyCurrentUrl();
        driver.navigate().refresh();
        partnerPage.mouseHoverToOpenConnectMenu();
        ContactUsConnectPage contactUsConnectPage = partnerPage.goToContactUsConnectPage();

        String actualContactUsPageUrl = driver.getCurrentUrl();
        String expectedContactUsPageUrl = getProperty("connectContactUsUrl");
        contactUsConnectPage.verifyCurrentUrl(expectedContactUsPageUrl);
        Assert.assertEquals(actualContactUsPageUrl,expectedContactUsPageUrl);
        VersaAIPage aiPage = contactUsConnectPage.gotoVersaAIPage();

        String actualAiUrl = driver.getCurrentUrl();
        String expectedAiUrl = getProperty("versaAiUrl");
        aiPage.verifyCurrentUrl(expectedAiUrl);
        Assert.assertEquals(actualAiUrl,expectedAiUrl);
        BookADemoPage demoPage = aiPage.goToDemoPage();

        String actualDemoUrl = driver.getCurrentUrl();
        String expectedDemoUrl = getProperty("demoPageUrl");
        demoPage.verifyCurrentUrl(expectedDemoUrl);
        Assert.assertEquals(actualDemoUrl,expectedDemoUrl);




    }
}
