package hm11.coffee.order;

public class Order {
    private final int number;
    private final String customerName;

    public Order(int number, String customerName) {
        this.number = number;
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Order{number=" + number + ", customerName='" + customerName + "'}";
    }
}