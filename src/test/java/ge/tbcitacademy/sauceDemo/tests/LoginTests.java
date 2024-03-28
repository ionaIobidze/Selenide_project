package ge.tbcitacademy.sauceDemo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.steps.BasicSteps;
import ge.tbcitacademy.steps.SauceDemoLoginSteps;
import ge.tbcitacademy.steps.SauceDemoMainSteps;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static ge.tbcitacademy.util.Util.configureBrowser;

@Epic("Authentication")
public class LoginTests {

    BasicSteps basicSteps = new BasicSteps();
    SauceDemoLoginSteps sauceDemoLoginSteps = new SauceDemoLoginSteps();
    SauceDemoMainSteps sauceDemoMainSteps = new SauceDemoMainSteps();

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setupTest(@Optional("firefox") String browser) {
        configureBrowser(browser.toLowerCase());
        Configuration.timeout = 6000;
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        if (WebDriverRunner.getWebDriver() != null) {
            WebDriverRunner.closeWebDriver();
        }
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Login")
    @Story("Login as Standard User")
    public void testStandardUser(){
        basicSteps.sauceDemo();
        sauceDemoLoginSteps.userInit(1).enterUsername().enterPassword().clickLoginBtn();
        sauceDemoMainSteps.checkIfImagesAreLoaded();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login")
    @Story("Login as Banned User")
    public void testBannedUser(){
        basicSteps.sauceDemo();
        sauceDemoLoginSteps.userInit(2).enterUsername().enterPassword().clickLoginBtn().validateEpicSadface().validateRedX();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login")
    @Story("Login with Problematic User")
    public void testProblematicLogin(){
        basicSteps.sauceDemo();
        sauceDemoLoginSteps.userInit(3).enterUsername().enterPassword().clickLoginBtn();
        sauceDemoMainSteps.checkIfImagesAreLoaded();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login")
    @Story("Logout")
    public void testLogOut(){
        basicSteps.sauceDemo();
        sauceDemoLoginSteps.userInit(1).enterUsername().enterPassword().clickLoginBtn();
        sauceDemoMainSteps.logOut();
        sauceDemoLoginSteps.usernameEmpty().passwordEmpty();
    }
}
