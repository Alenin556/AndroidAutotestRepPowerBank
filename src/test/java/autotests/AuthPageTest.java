package autotests;

import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import io.qameta.allure.TmsLink;
import pages.AuthPage;

public class AuthPageTest extends BaseTest {
    @Test
    @DisplayName("Проверка состояния кнопки войти")
    public void enterAuthButtonTest() {
        step("Проверить что кнопка \"войти\" присутствует на экране", () -> {
            WebElement authButton = driver.findElement(By.id("button_auth"));
            authButton.isEnabled();
            authButton.click();
        });
    }

}
