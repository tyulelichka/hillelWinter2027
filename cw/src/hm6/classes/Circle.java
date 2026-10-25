package hm6.classes;

import hm6.interfaces.Figure;

public class Circle implements Figure {

    private double r;
    private double square;

    public Circle(double r) {
        if (r <= 0) {
            System.out.println("A radius cannot be negative.");
        } else this.r = r;
        square = 0;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public double square() {
        double pi = Math.PI;
        square = pi * Math.pow(r, 2);
        if (square < 0) {
            System.out.println("Square < 0");
        }
        return square;
    }

}
