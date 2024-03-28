package ge.tbcitacademy.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static ge.tbcitacademy.data.Constants.*;

public class Util {
    public static void configureBrowser(String browser) {
        Configuration.browser = browser.toLowerCase();
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile profile = new FirefoxProfile();
                firefoxOptions.setProfile(profile);
                Configuration.browserCapabilities = firefoxOptions;
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File(chromiumAddBlocker));
                Configuration.browserCapabilities = chromeOptions;
                break;
            case "edge":
                ChromeOptions edgeOptions = new ChromeOptions();
                edgeOptions.addExtensions(new File(chromiumAddBlocker));
                Configuration.browserCapabilities = edgeOptions;
                break;
            default:
                throw new IllegalArgumentException(unsopportedBrowser + browser);
        }
    }

    public static SelenideElement visibleElementReturner (ElementsCollection elements){
        for(SelenideElement element : elements){
            if(element.isDisplayed()){
                return element;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean areElementsWithinRange(ElementsCollection elements, String min, String max) {
        for (int i = 0; i < elements.size(); i++) {
            int number = Integer.parseInt(elements.get(i).getText().replaceAll("\\D", ""));
            if (number > Integer.parseInt(max) || number < Integer.parseInt(min)) {
                return false;
            }
        }
        return true;
    }

}
