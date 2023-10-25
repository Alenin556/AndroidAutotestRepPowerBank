package autotests.helper;



import com.codeborne.selenide.SelenideElement;

import autotests.BaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class EmulatorHelper extends BaseTest {

        //закрытие приложения
        public static void closeApp() {
            driver.quit();
        }
}