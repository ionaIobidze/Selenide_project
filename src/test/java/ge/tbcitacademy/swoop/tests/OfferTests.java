package ge.tbcitacademy.swoop.tests;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.data.VacationDataProvider;
import ge.tbcitacademy.pages.EstheticsPage;
import ge.tbcitacademy.pages.SwoopBasicPage;
import ge.tbcitacademy.steps.BasicSteps;
import ge.tbcitacademy.steps.EstethicsPageSteps;
import ge.tbcitacademy.steps.SwoopDasvenebaSteps;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static ge.tbcitacademy.util.Util.configureBrowser;

@Epic("Offer Management")
public class OfferTests {

    BasicSteps basicSteps = new BasicSteps();
    SwoopBasicPage swoopBasicPage = new SwoopBasicPage();
    EstheticsPage estetikaPage = new EstheticsPage();
    SwoopDasvenebaSteps swoopDasvenebaSteps = new SwoopDasvenebaSteps();
    EstethicsPageSteps estetikaPageSteps = new EstethicsPageSteps();

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setupTest(@Optional("firefox") String browser) {
        configureBrowser(browser.toLowerCase());
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        if (WebDriverRunner.getWebDriver() != null) {
            WebDriverRunner.closeWebDriver();
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Browse Offers")
    @Story("Range Selection")
    public void testRange() {
        basicSteps.openSwoop().click(swoopBasicPage.dasvenebaElement);
    }

    @Test(dependsOnMethods = {"testRange"}, dataProvider = "boundsProvider", dataProviderClass = VacationDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Browse Offers")
    @Story("Validate Price Range")
    public void testBounds(String minPrice, String maxPrice) {
        swoopDasvenebaSteps.sendMinPrice(minPrice).sendMaxPrice(maxPrice).clickDzebna().checkTheRange(minPrice, maxPrice);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Favorite Offers")
    @Story("Add Offer to Favorites")
    public void testFavouriteOffer() {
        basicSteps.openSwoop().click(swoopBasicPage.categoriesEl).click(swoopBasicPage.estetikaEl());
        estetikaPageSteps.clickToAddItInFavs().loginPageHasAppeared().goBack();
        basicSteps.click(estetikaPage.pirveliDeal());
        estetikaPageSteps.checkVauchers();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.MINOR)
    @Feature("Social Sharing")
    @Story("Share on Facebook")
    public void tesShare() {
        basicSteps.openSwoop().click(swoopBasicPage.categoriesEl).click(swoopBasicPage.estetikaEl()).click(estetikaPage.pirveliDeal());
        estetikaPageSteps.shareOnFacebook();
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Offer Availability")
    @Story("Check No Offers Sold")
    public void testNoOffersSold() {
        basicSteps.openSwoop().click(swoopBasicPage.categoriesEl).click(swoopBasicPage.estetikaEl());
        estetikaPageSteps.clickOfferWithNoSale().checkThatNoOffersSold();
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Filter Offers")
    @Story("Apply Filters")
    public void testFilters(){
        basicSteps.openSwoop().click(swoopBasicPage.categoriesEl).click(swoopBasicPage.estetikaEl());
        estetikaPageSteps.chooseLocation().chooseSruliGadaxda().sendMinPrice().sendMaxPrice().clearFilters().checkFilterResults();
    }
}
