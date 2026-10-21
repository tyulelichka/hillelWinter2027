package hm4;

import hm4.pack1.SameName;

public class Main {
    public static void main(String[] args) {
        SameName sameName1 = new SameName();
        sameName1.sayHello();

        hm4.pack2.SameName sameName2 = new hm4.pack2.SameName();
        sameName2.sayHello();

        Employee employee = new Employee();
        employee.printEmp();

        Car car = new Car();
        car.start();
        // car.startElectricity(); 'startElectricity()' has private access in 'hm4.Car'

    }
}
