package settings.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public interface WebDriverProvider {
    @Nonnull
    abstract WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}
