package ge.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbcitacademy.util.Util.visibleElementReturner;

public class EstheticsPage {

    public SelenideElement gapavoriteba(){
        return $$x("//*[@class=\"deal-box-wishlist\"]").get(0);
    }

    public SelenideElement pirveliDeal(){
        return $$x("//*[@class=\"special-offer\"]").get(0);
    }

    public SelenideElement vouchers = $x("//*[@class=\"validation-count\"]");

    public SelenideElement fbEl = $x("//*[@class=\"merchantFacebook\"]");

    public SelenideElement fbLogin = $x("//form[contains(@action, 'https://www.facebook.com/login')]");

    public SelenideElement soldNoneEl = $x("//div[@class='outs-and-shorts']/p[contains(text(), 'გაყიდულია 0')]/../../../..");

    public SelenideElement locationDropDwn(){
        return visibleElementReturner($$x("//span[text()='ყველა მდებარეობა']"));
    }

    public SelenideElement vaceLocationOption(){
        return visibleElementReturner($$x("//span[text()='ვაკე']"));
    }

    public SelenideElement sruliGadaxdaOption(){
        return visibleElementReturner($$x("//label[contains(text(), 'სრული გადახდა')]"));
    }

    public SelenideElement minPriceEl(){
        return visibleElementReturner($$x("//*[@id='minprice']"));
    }
    public SelenideElement maxPriceEl(){
        return visibleElementReturner($$x("//*[@id='maxprice']"));
    }

    public SelenideElement dellSearchButtonEl(){
        return visibleElementReturner($$x("//div[@class=\"delete-search-button\"]"));
    }

    public SelenideElement dropdownElPlaceholder(){
        return visibleElementReturner($$x("//span[@class=\"placeholder\" and text() = 'ყველა მდებარეობა']"));
    }

    public SelenideElement paymentMethodYvela(){
        return visibleElementReturner($$x("//label[text()='ყველა']"));
    }
}
