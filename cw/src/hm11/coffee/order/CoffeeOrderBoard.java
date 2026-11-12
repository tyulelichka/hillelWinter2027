package hm11.coffee.order;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoffeeOrderBoard {
    private final List<Order> orders = new ArrayList<>();
    private int lastNumber = 0;


    public Order add(String customerName) {
        Order order = new Order(++lastNumber, customerName);
        orders.add(order);
        return order;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            System.out.println("Not order");
            return null;
        }
        Order order = orders.remove(0);
        System.out.println("Finish: "  + order);
        return order;
    }

    public Order deliver(int number) {
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getNumber() == number) {
                iterator.remove();
                System.out.println("Finish: " + order);
                return order;
            }
        }
        System.out.println("Order number " + number + " isn't");
        return null;
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getCustomerName());
        }
        System.out.println("=============");
    }
}