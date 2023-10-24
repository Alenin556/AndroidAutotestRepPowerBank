package autotests;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.qameta.allure.Allure.step;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseTest {

    private static AppiumDriver driver;


    @BeforeAll
    public static void initialize() throws Exception {
        Configuration.browser = "deviceHost";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME, "Pixel 2 API 30 Emulator");
        capabilities.setCapability(PLATFORM_NAME, "android");
        capabilities.setCapability(APP_PACKAGE, "ru.astondevs.powerbank");
        capabilities.setCapability(APP_ACTIVITY, "ru.astondevs.powerbank.MainActivity");
        capabilities.setCapability(APP,"C:\\Projects\\PowerBankAndriodAppAutotests\\src\\test\\resources\\apk\\PowerBankApp\\Auth.apk");

       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    @DisplayName("Проверка состояния кнопки войти")
    public void enterAuthButtonTest() {
        step("Проверить что кнопка \"войти\" присутствует на экране", () -> {
            WebElement authButton = driver.findElement(By.id("button_auth"));
            authButton.click();
        });
    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        //close driver / app
        Thread.sleep(5000);
        driver.quit();
    }

}

