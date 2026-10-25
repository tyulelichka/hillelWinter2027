package hm6.classes;

import hm6.interfaces.Figure;

public class Square implements Figure {
    private int a;
    private double square;

    public Square(int a) {
        if (a <= 0) {
            System.out.println("The side of a square cannot be negative.");
        } else this.a = a;
        square = 0;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public double square() {
     square = Math.pow(a, 2);
        if (square < 0) {
            System.out.println("Square < 0");
        }
        return square;
    }
}
