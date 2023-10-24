package settings.helper;


import static settings.helper.DeviceHelper.executeSh;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import settings.config.ConfigReader;

public class ApkInfoHelper {
    private String apkInfo;

    // метод необходимый для чтения логов файла, для присвоения значений к полям appPackage и appActivity
    public ApkInfoHelper() {
        String app = ConfigReader.emulatorConfig.app();
        if (app == null || app.isEmpty()) {
            throw new RuntimeException("No value for key 'app' providing apk path in properties.\n Нет значения для ключа «app», указывающего путь к apk файлу, в файлах properties.");
        }
        try {
            String pathToAapt = "C:\\Users\\Asus\\AppData\\Local\\Android\\Sdk\\build-tools\\33.0.2";
            apkInfo = executeSh(pathToAapt + "aapt dumb badging" + ConfigReader.emulatorConfig.app());
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAppPackageFromApk() {
        return findGroupValueFromString(apkInfo, "package: name='\\s*([^']+?)\\s*'");
    }

    public String getAppMainActivity() {
        return findGroupValueFromString(apkInfo, "launchable-activity: name=''\\s*([^']+?)\\s*'");
    }

    private static String findGroupValueFromString(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
