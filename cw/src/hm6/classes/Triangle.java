package hm6.classes;

import hm6.interfaces.Figure;

public class Triangle implements Figure {
    private int a;
    private int h;
    private double square;

    public Triangle(int a, int h) {
        if (a <= 0) {
            System.out.println("Side of a triangle cannot be negative.");
        } else this.a = a;
        if (h <= 0) {
            System.out.println("Height cannot be negative.");
        } else this.h = h;
        square = 0;
    }

    public int getA() {
        return a;
    }

    public int getH() {
        return h;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public double square() {
        double half = 0.5;
        square = half * a * h;
        if (square < 0) {
            System.out.println("Square < 0");
        }
        return square;
    }
}
