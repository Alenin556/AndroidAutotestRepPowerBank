package settings.helper;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class DeviceHelper {

    /**
     * Чтение в потоке
     * @param command
     * @return
     * @throws java.io.IOException
     * @throws java.util.concurrent.ExecutionException
     * @throws InterruptedException
     */

    public static String executeSh(String command) throws IOException, ExecutionException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command);
        FutureTask<String> future = new FutureTask<>(() -> {
            return new BufferedReader(new InputStreamReader(p.getInputStream()))
                    .lines().map(Object::toString)
                    .collect(Collectors.joining("\n"));
        });
        new Thread(future).start();
        return future.get();
    }

}
