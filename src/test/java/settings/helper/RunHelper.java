package settings.helper;

import settings.config.ConfigReader;
import settings.driver.EmulatorDriver;

public class RunHelper {

    private RunHelper() {
    }

    public static RunHelper runHelper(){
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        String deviceHost = ConfigReader.testConfig.deviceHost();

        switch (deviceHost) {
            case "emulator" :
                return EmulatorDriver.class;
            default:
                throw new RuntimeException("В файле properties нет параметра deviceHost");
        }
    }

}
