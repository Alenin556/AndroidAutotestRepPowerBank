package settings.driver;



import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class EmulatorHelper extends EmulatorDriver {

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

//    public static void androidScrollToAnElementByText(String text) {
//        String command = "new UiScrollable(new UiSelector()" +
//                ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
//                ".textContains(\"" + text + "\").instance(0))";
//        driver.find(command)
//                .click();
//    }
}
