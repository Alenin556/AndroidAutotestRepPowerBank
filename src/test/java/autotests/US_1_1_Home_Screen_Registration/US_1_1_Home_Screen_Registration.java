package autotests.US_1_1_Home_Screen_Registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import autotests.BaseTest;
import io.qameta.allure.TmsLink;

public class US_1_1_Home_Screen_Registration extends BaseTest {

    @Test
    @TmsLink("6725401")
    @DisplayName("US 1.1 Проверка отображения экрана онбординга")
    public void checkingTheDisplayOfTheOnboardingScreenTest() {

        step("Осуществить первый запуск приложения.\n" +
                "После запуска временно отобразится логотип приложения и перенаправит на экран онбординга" +
                " с информацией о представлении приложения.", () -> {
            WebElement mainScreenInfo = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]"));

            String infoText = mainScreenInfo.getText();
            System.out.println(infoText);


          //  assertEquals("инновационный подход к деньгам",infoText);

        });
    }
}

