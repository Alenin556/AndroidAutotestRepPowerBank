package autotests.settings.driver;


import autotests.settings.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;


public class Constants {
    protected static AndroidDriver driver;
    private static  final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static  final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();

    private static String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static   String APP = ConfigReader.emulatorConfig.app();
    private static  final String URL = ConfigReader.emulatorConfig.remoteUrl();


}
