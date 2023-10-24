package settings.driver;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.Nonnull;
import settings.config.ConfigReader;
import settings.helper.ApkInfoHelper;
import io.appium.java_client.android.AndroidDriver;


public class EmulatorDriver implements WebDriverProvider {
    protected static AndroidDriver driver;
    private static  final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static  final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();

    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static  final String APP = ConfigReader.emulatorConfig.app();
    private static  final String URL = ConfigReader.emulatorConfig.remoteUrl();

    public static URL getUrl() { // для проверки ссылки на appium
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //если в файлах properties не указаны поля, то значения будут присвоены через чтение файла apk, с помощью методов класса ApkHelper
    private void initPackageAndActivity() {
        ApkInfoHelper helper = new ApkInfoHelper();
        APP_PACKAGE = APP_PACKAGE.isEmpty() ? helper.getAppPackageFromApk() : APP_PACKAGE;
        APP_ACTIVITY = APP_ACTIVITY.isEmpty() ? helper.getAppMainActivity() : APP_ACTIVITY;
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        Assertions.assertTrue(file.exists(), filePath + "файл не найден.");

        return  file.getAbsolutePath();
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        initPackageAndActivity();

        desiredCapabilities.setCapability("autoGranPermissions", "true");

        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);
        desiredCapabilities.setCapability("appPackage", APP_PACKAGE);
        desiredCapabilities.setCapability("appActivity", APP_ACTIVITY);

        desiredCapabilities.setCapability("app", getAbsolutePath(APP));
        driver = new AndroidDriver(getUrl(), desiredCapabilities);
        return driver;
    }

}
