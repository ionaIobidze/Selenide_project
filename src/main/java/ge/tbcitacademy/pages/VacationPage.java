package ge.tbcitacademy.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static ge.tbcitacademy.util.Util.visibleElementReturner;


public class VacationPage {
    public SelenideElement minPriceEl(){
        return visibleElementReturner($$x("//*[@id='minprice']"));
    }
    public SelenideElement maxPriceEl(){
        return visibleElementReturner($$x("//*[@id='maxprice']"));
    }
    public SelenideElement dzebnaBtn(){
        return visibleElementReturner($$x("//*[@class=\"submit-button\"]"));
    }
    public ElementsCollection priceElements = $$x("//*[@class='deal-description']//*[@class='discounted-prices']/p[1]");

}
