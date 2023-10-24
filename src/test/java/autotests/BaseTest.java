package autotests;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;


public class BaseTest {

    @BeforeAll
    public static void initialize() throws MalformedURLException {
        Configuration.browser = "deviceHost";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoGranPermissions", "true");

        capabilities.setCapability(DEVICE_NAME, "Pixel 2 API 30 Emulator");
        capabilities.setCapability(PLATFORM_NAME, "android");
        capabilities.setCapability(APP_PACKAGE, "ru.astondevs.powerbank");
        capabilities.setCapability(APP_ACTIVITY, "MainActivity");

//        capabilities.setCapability(DEVICE_NAME,"deviceName");
//        capabilities.setCapability(PLATFORM_NAME,"platformName");
//        capabilities.setCapability(APP_PACKAGE,"appPackage");
//        capabilities.setCapability(APP_ACTIVITY, "appActivity");
//        capabilities.setCapability(APP, "app");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        try {
//            driver = new AndroidDriver(new URL("remoteUrl"), capabilities);
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        } catch (MalformedURLException e) {
//            System.out.println(e.getMessage());
//        }




    }
}
