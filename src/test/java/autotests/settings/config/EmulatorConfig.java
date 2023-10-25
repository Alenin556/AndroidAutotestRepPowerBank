package autotests.settings.config;

import org.aeonbits.owner.Config;
//благодаря библиотеки происходит чтение пропертей

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties", // указываем тип данных
        "src/test/resources/configs/PowerBankEmulator.properties", //указываем какой файл мы будем читать
})
public interface EmulatorConfig extends Config {

    //ключи ссылаются на файлы properties
    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("app")
    String app();
}
