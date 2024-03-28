package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.VacationPage;
import ge.tbcitacademy.pages.SwoopBasicPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static ge.tbcitacademy.util.Util.areElementsWithinRange;

public class SwoopDasvenebaSteps {

    VacationPage dasvenebaPage = new VacationPage();
    SwoopBasicPage swoopStartingPage = new SwoopBasicPage();

    /**
     * Checks if the price elements are within the specified range.
     *
     * @param min The minimum price
     * @param max The maximum price
     * @return SwoopDasvenebaSteps instance
     */
    public SwoopDasvenebaSteps checkTheRange(String min, String max) {
        swoopStartingPage.freezElement.shouldNot(exist);
        Assert.assertTrue(areElementsWithinRange(dasvenebaPage.priceElements, min, max));
        return this;
    }

    /**
     * Sends the minimum price.
     *
     * @param min The minimum price to send
     * @return SwoopDasvenebaSteps instance
     */
    public SwoopDasvenebaSteps sendMinPrice(String min) {
        dasvenebaPage.minPriceEl().clear();
        dasvenebaPage.minPriceEl().sendKeys(min);
        return this;
    }

    /**
     * Sends the maximum price.
     *
     * @param max The maximum price to send
     * @return SwoopDasvenebaSteps instance
     */
    public SwoopDasvenebaSteps sendMaxPrice(String max) {
        dasvenebaPage.maxPriceEl().clear();
        dasvenebaPage.maxPriceEl().sendKeys(max);
        return this;
    }

    /**
     * Clicks the "ძებნა" button.
     *
     * @return SwoopDasvenebaSteps instance
     */
    public SwoopDasvenebaSteps clickDzebna(){
        dasvenebaPage.dzebnaBtn().click();
        return this;
    }

}
