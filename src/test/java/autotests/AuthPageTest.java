package autotests;

import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import io.qameta.allure.TmsLink;
import pages.AuthPage;

public class AuthPageTest extends BaseTest {
    AuthPage authPage = new AuthPage();

    @Test
    @DisplayName("Проверка состояния кнопки войти")
    public void enterAuthButtonTest() throws MalformedURLException {
        initialize();
        step("Проверить что кнопка \"войти\" присутствует на экране", () -> {
            authPage.authButton.shouldBe(Condition.exist);
        });
    }

}
