package hm11;

import hm11.coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Elena");
        board.add("Ivan");
        board.add("Maria");
        board.add("Petr");
        board.draw();

        board.deliver();
        board.deliver(3);
        board.draw();

        board.add("Anna");
        board.draw();
        board.deliver(5);
        board.add("Anna");
        board.draw();
    }
}
