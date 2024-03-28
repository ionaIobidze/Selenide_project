package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.pages.EstheticsPage;
import ge.tbcitacademy.pages.SwoopBasicPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static ge.tbcitacademy.data.Constants.*;

public class EstethicsPageSteps {

    SwoopBasicPage swoopBasicPage = new SwoopBasicPage();
    EstheticsPage estetikaPage = new EstheticsPage();

    /**
     * Clicks to add the offer in favorites.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps clickToAddItInFavs(){
        estetikaPage.gapavoriteba().click();
        return this;
    }

    /**
     * Verifies if the login page has appeared.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps loginPageHasAppeared(){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(loginLink));
        return this;
    }

    /**
     * Goes back to the previous page.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps goBack(){
        Selenide.back();
        return this;
    }

    /**
     * Checks vouchers.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps checkVauchers(){
        estetikaPage.vouchers.shouldNotHave(matchText("100"));
        return this;
    }

    /**
     * Shares on Facebook.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps shareOnFacebook(){
        estetikaPage.fbEl.click();
        switchTo().window(1);
        estetikaPage.fbLogin.should(exist);
        return this;
    }

    /**
     * Clicks the offer with no sale.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps clickOfferWithNoSale(){
        estetikaPage.soldNoneEl.click();
        return this;
    }

    /**
     * Checks that no offers are sold.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps checkThatNoOffersSold(){
        estetikaPage.vouchers.$x("./div[@style='width:0%;']").should(exist);
        return this;
    }

    /**
     * Chooses a location.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps chooseLocation(){
        SelenideElement dropdwn = estetikaPage.locationDropDwn();
        dropdwn.click();
        estetikaPage.vaceLocationOption().should(exist).click();
        swoopBasicPage.freezElement.shouldNot(exist);
        dropdwn.click();
        return this;
    }

    /**
     * Chooses Sruli Gadaxda.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps chooseSruliGadaxda(){
        estetikaPage.sruliGadaxdaOption().click();
        return this;
    }

    /**
     * Sends minimum price.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps sendMinPrice() {
        estetikaPage.minPriceEl().clear();
        estetikaPage.minPriceEl().sendKeys(arbitatryMin);
        return this;
    }

    /**
     * Sends maximum price.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps sendMaxPrice() {
        estetikaPage.maxPriceEl().clear();
        estetikaPage.maxPriceEl().sendKeys(arbitatryMax);
        return this;
    }

    /**
     * Clears filters.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps clearFilters(){
        estetikaPage.dellSearchButtonEl().click();
        swoopBasicPage.freezElement.shouldNot(exist);
        return this;
    }

    /**
     * Checks filter results.
     *
     * @return EstetikaPageSteps instance
     */
    public EstethicsPageSteps checkFilterResults(){
        estetikaPage.dropdownElPlaceholder().should(exist);
        estetikaPage.paymentMethodYvela().isSelected();
        estetikaPage.maxPriceEl().shouldBe(empty);
        estetikaPage.minPriceEl().shouldBe(empty);
        return this;
    }
}
