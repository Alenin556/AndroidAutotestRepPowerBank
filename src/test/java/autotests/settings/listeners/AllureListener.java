package autotests.settings.listeners;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import java.lang.reflect.Method;
import io.qameta.allure.Attachment;

public class AllureListener implements AfterTestExecutionCallback {

    //Метод прикрепляет скриншот к отчету Allure
    @Attachment (value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }

    //если тест падает, то к Allure отчету прикрепляется скрин экрана перед падением

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method tesMethod = context.getRequiredTestMethod();
        String testName = tesMethod.getName();
        boolean testFailed = context.getExecutionException().isPresent();
        if (testFailed) {
            if(!testName.contains("Screenshot")) {
                saveScreenshot(Selenide.screenshot(OutputType.BYTES));
            }
        }
    }
}
