package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SauceDemoMainPage;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class SauceDemoMainSteps {

    SauceDemoMainPage sauceDemoMainPage = new SauceDemoMainPage();

    /**
     * Checks if images are loaded on the main page.
     *
     * @return SauceDemoMainSteps instance
     */
    public SauceDemoMainSteps checkIfImagesAreLoaded(){
        sauceDemoMainPage.inventoryContainer.should(exist).shouldBe(visible);
        boolean allImagesLoaded = Boolean.TRUE.equals(executeJavaScript(
                "return Array.from(document.querySelectorAll('#inventory_container img')).every(img => img.complete && img.naturalWidth > 0);"
        ));
        Assert.assertTrue(allImagesLoaded);
        return this;
    }

    /**
     * Logs out from the application.
     *
     * @return SauceDemoMainSteps instance
     */
    public SauceDemoMainSteps logOut(){
        sauceDemoMainPage.menuButton.click();
        sauceDemoMainPage.logOutButton.click();
        return this;
    }

}
