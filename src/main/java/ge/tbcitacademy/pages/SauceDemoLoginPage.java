package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SauceDemoLoginPage {

    public SelenideElement username = $(By.id("user-name"));
    public SelenideElement password = $(By.id("password"));
    public SelenideElement loginBtn = $(By.id("login-button"));
    public SelenideElement epicSadface = $x("//*[@data-test='error']");
    public SelenideElement redX = $("svg[data-icon='times-circle']");

}
