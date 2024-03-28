package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbcitacademy.util.Util.visibleElementReturner;

public class SwoopBasicPage {

    public SelenideElement dasvenebaElement = $x("//div[@class='MenuIcon' and ancestor::a[contains(., 'დასვენება')]]");

    public SelenideElement categoriesEl = $x("//*[@class=\"categoriesTitle\"]");

    public SelenideElement estetikaEl(){
        return visibleElementReturner($$x("//a[contains(text(),'ესთეტიკა')]"));
    }
    public SelenideElement freezElement = $x("//div[@class='freeze']");

}



