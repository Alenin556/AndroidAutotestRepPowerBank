package autotests.settings.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "src/test/resources/configs/test.properties",
})
public interface TestConfig extends Config {
    @Key("updateScreenshots")
    @DefaultValue("false")
    boolean isScreenshotsToUpdate();

    @Key("deviceHost")
    String deviceHost();
}
