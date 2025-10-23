public class FactoryMethodDemo {
    public static void main(String[] args) {
        Application app;

        String env = "PROD";

        if (env.equals("DEV")) {
            app = new DevApp();
        } else {
            app = new ProdApp();
        }

        app.run();
    }
}

interface Logger {
    void log(String message);
}
class ConsoleLogger implements Logger {
    public void log(String message) {
        System.out.println("[Console] " + message);
    }
}

class FileLogger implements Logger {
    public void log(String message) {
        System.out.println("[File] " + message);
    }
}
abstract class Application {
    protected abstract Logger createLogger();

    public void run() {
        Logger logger = createLogger();
        logger.log("Starting the app...");
        logger.log("App finished successfully!");
    }
}
class DevApp extends Application {
    @Override
    protected Logger createLogger() {
        return new ConsoleLogger();
    }
}

class ProdApp extends Application {
    @Override
    protected Logger createLogger() {
        return new FileLogger();
    }
}
