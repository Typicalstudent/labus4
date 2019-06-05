import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;


public class Order implements Runnable {
    private static CashBox box = new CashBox();
    private static ArrayList<String> customerList;
    private static ArrayList<String> defOrderList;
    private int id;

    public Order(int i) {
        id = i;
    }

    public static void main(String[] args) throws InterruptedException {
        Order.box = new CashBox();
        customerList = new ArrayList<String>();
        defOrderList = new ArrayList<String>();
        Log log = new Log();

        defOrderList.add("Cheeseburger");
        defOrderList.add("Big Fri");
        defOrderList.add("Kola 05");

        customerList.add("Sergey");
        customerList.add("Evgeniy");
        customerList.add("Alexander");
        customerList.add("Mikhail");
        customerList.add("Alexey");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Order(i));
        }
        exec.shutdown();
    }

    public void run() {
        Customer human = new Customer(customerList.get(id));
        Kitchen kitchen = new Kitchen();
        try {
            synchronized (box) {
                human.MakeChoise(box);
            }
            kitchen.MakeOrder(defOrderList);
        } catch (InterruptedException ex) {
            Log.logging("Error: Interrupted");
        }
        while (!kitchen.isReady()) ;
        Log.logging(human.getName() + "'s order is ready");
    }
}
