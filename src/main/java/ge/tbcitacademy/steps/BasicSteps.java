package ge.tbcitacademy.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbcitacademy.data.Constants.firstLink;
import static ge.tbcitacademy.data.Constants.secondLink;

public class BasicSteps {

    /**
     * Opens the first link.
     *
     * @return BasicSteps instance
     */
    public BasicSteps openSwoop(){
        open(firstLink);
        return this;
    }

    /**
     * Opens the second link.
     *
     * @return BasicSteps instance
     */
    public BasicSteps sauceDemo(){
        open(secondLink);
        return this;
    }

    /**
     * Clicks on the specified Selenide element.
     *
     * @param element The SelenideElement to click on
     * @return BasicSteps instance
     */
    public BasicSteps click(SelenideElement element) {
        element.click();
        return this;
    }

    /**
     * Sends keys to the specified Selenide element.
     *
     * @param element The SelenideElement to send keys to
     * @param text The text to send
     * @return BasicSteps instance
     */
    public BasicSteps sendKeys(SelenideElement element, String text) {
        element.sendKeys(text);
        return this;
    }

    /**
     * Clears the specified Selenide element.
     *
     * @param element The SelenideElement to clear
     * @return BasicSteps instance
     */
    public BasicSteps clearElement(SelenideElement element) {
        element.clear();
        return this;
    }
}
