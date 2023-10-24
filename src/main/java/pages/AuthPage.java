package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

public class AuthPage{

    public final SelenideElement authButton = $(AppiumBy.ByAndroidUIAutomator.id("button_auth"));
}
