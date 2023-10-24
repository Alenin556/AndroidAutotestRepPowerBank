package autotests;

import static settings.helper.Constants.SCREENSHOT_TO_SAVE_FOLDER;
import static settings.helper.DeviceHelper.executeSh;
import static settings.helper.RunHelper.runHelper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import io.qameta.allure.selenide.AllureSelenide;
import settings.listeners.AllureListener;

@ExtendWith(AllureListener.class)
public class BaseTest {

    @BeforeAll
    public void setup() throws IOException, ExecutionException, InterruptedException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //папка для сохранения скриншотов selenide
        Configuration.reportsFolder =  SCREENSHOT_TO_SAVE_FOLDER;

        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        disableAnimationOnEmulator();
    }

    //отключает анимации, для ускорения и корректности работы эмулятора
    private static void disableAnimationOnEmulator() throws IOException, ExecutionException, InterruptedException {
        executeSh("adb -s shell settings put global transition_animation_scale 0.0");
        executeSh("adb -s shell settings put global window_animation 0.0");
        executeSh("adb -s shell settings put global animator_duration_scale 0.0");
    }


}
