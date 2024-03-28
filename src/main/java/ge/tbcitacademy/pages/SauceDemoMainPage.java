package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SauceDemoMainPage {

    public SelenideElement inventoryContainer =  $("#inventory_container");
    public SelenideElement menuButton = $(By.id("react-burger-menu-btn"));
    public SelenideElement logOutButton = $(By.id("logout_sidebar_link"));
}
