import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name;
    private ArrayList<String> orderList;

    public Customer(String name) {
        this.name = name;
        orderList = new ArrayList<String>();
    }

    public void MakeChoise(CashBox box) throws InterruptedException {
        box.TakeOrder();
    }

    public String getName() {
        return name;
    }
}
