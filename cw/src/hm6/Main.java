package hm6;

import hm6.classes.*;
import hm6.interfaces.*;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.square();
        System.out.println("Circle's square = " + circle.square());
        Circle circle1 = new Circle(-3);
        System.out.println("-------------");

        Square square = new Square(7);
        square.square();
        System.out.println("Square's square = " + square.square());
        System.out.println("-------------");

        Triangle triangle = new Triangle(10, 8);
        triangle.square();
        System.out.println("Triangle's square = " + triangle.square());
        System.out.println("-------------");

        Figure[] figures = {circle, square, triangle};
        double total = sumSquare(figures);
        System.out.println(total);
        System.out.println("-------------");

        Cat cat = new Cat();
        Person person = new Person();
        Robot robot = new Robot();
        Member[] members = {cat, person, robot};
        Treadmill treadmill = new Treadmill();
        Wall wall = new Wall();
        Obstacle[] obstacles = {treadmill, wall};
        interaction(members, obstacles);
        System.out.println("-------------");

        interactionLimitation(members, obstacles, 50);


    }

    public static double sumSquare(Figure[] figures) {
        double sum = 0;
        for (Figure f : figures) {
            sum += f.square();
        }
        return sum;
    }

    public static void interaction(Member[] members, Obstacle[] obstacles) {
        for (Member member : members) {
            for (Obstacle obstacle : obstacles) {
                obstacle.overcome(member);
            }
        }
    }

    public static void interactionLimitation(Member[] members, Obstacle[] obstacles, int a) {
        for (Member member : members) {
            for (Obstacle obstacle : obstacles) {
                obstacle.overcomeLimitation(member, a);
            }
        }
    }
}