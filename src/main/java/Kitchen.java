import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Kitchen {
    private volatile boolean ready;

    public Kitchen() {
        ready = false;
    }

    public void MakeOrder(ArrayList<String> order) throws InterruptedException {
        ready = false;
        Log.logging("Kitchen starts to make order");
        for (String i : order) {
            Log.logging(i + " is making...");
            TimeUnit.MILLISECONDS.sleep(200);
            Log.logging(i + " ready");
        }
        ready = true;
    }

    public boolean isReady() {
        return ready;
    }
}
