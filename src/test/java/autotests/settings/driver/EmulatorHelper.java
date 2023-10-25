package autotests.settings.driver;



import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class EmulatorHelper extends Constants {

    public static void goBack() {
        driver.navigate().back();
    }

    //проверяет если клавиатура открыта, метод ее закрывает
    public static void closeKeyBoard() {
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
    }

    //вставляет вводные данные
    public static void sendKeysAndFind(SelenideElement element, String text) {
        element.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

}
