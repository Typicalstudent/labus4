import java.io.IOException;
import java.util.logging.*;

public class Log {
    FileHandler handler;
    private static Logger log = Logger.getLogger("LogFile");

    public Log() {
        try {
            handler = new FileHandler("C:\\Users\\Zhdanboro\\IdeaProjects\\Lab4\\LogFile.log");
            log.addHandler(handler);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
        }catch(SecurityException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void logging(String message) {
        log.info(message);
    }
}
