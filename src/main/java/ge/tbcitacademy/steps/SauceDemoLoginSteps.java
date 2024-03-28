package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SauceDemoLoginPage;
import ge.tbcitacademy.util.DatabaseUtil;
import ge.tbcitacademy.util.User;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;
import static ge.tbcitacademy.data.Constants.errorMessEpicSad;

public class SauceDemoLoginSteps {

    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    User user;

    /**
     * Initializes the user with the specified ID.
     *
     * @param id The ID of the user to initialize
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps userInit(int id){
        user = DatabaseUtil.getUserById(id);
        return this;
    }

    /**
     * Enters the username.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps enterUsername() {
        sauceDemoLoginPage.username.sendKeys(user.getUsername());
        return this;
    }

    /**
     * Enters the password.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps enterPassword() {
        sauceDemoLoginPage.password.sendKeys(user.getPassword());
        return this;
    }

    /**
     * Clicks the login button.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps clickLoginBtn(){
        sauceDemoLoginPage.loginBtn.click();
        return this;
    }

    /**
     * Validates the presence of epic sadface error message.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps validateEpicSadface(){
        sauceDemoLoginPage.epicSadface.shouldBe(visible);
        Assert.assertTrue(sauceDemoLoginPage.epicSadface.text().contains(errorMessEpicSad));
        return this;
    }

    /**
     * Validates the presence of red X.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps validateRedX(){
        sauceDemoLoginPage.redX.shouldBe(visible);
        return this;
    }

    /**
     * Validates that the username field is empty.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps usernameEmpty(){
        sauceDemoLoginPage.username.should(empty);
        return this;
    }

    /**
     * Validates that the password field is empty.
     *
     * @return SauceDemoLoginSteps instance
     */
    public SauceDemoLoginSteps passwordEmpty(){
        sauceDemoLoginPage.password.should(empty);
        return this;
    }
}
