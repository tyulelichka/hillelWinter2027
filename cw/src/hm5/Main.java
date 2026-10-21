package hm5;

import hm5.animal.Animal;
import hm5.animal.Cat;
import hm5.animal.Dog;

public class Main {
    public static void main(String[] args) {
        Animal am1 = new Animal("Lily");
        am1.run(12);
        am1.swim(-5);

        Cat c1 = new Cat("Ann");
        c1.run(100);
        c1.swim(20);

        Cat c2 = new Cat("Sue");
        c2.run(12);
        c2.swim(-10);

        Cat c3 = new Cat("Tar");
        c3.run(430);
        c3.swim(0);

        Dog d1 = new Dog("Mila");
        d1.run(100);
        d1.swim(20);

        Dog d2 = new Dog("Kiki");
        d2.run(12);
        d2.swim(-10);

        Dog d3 = new Dog("Nika");
        d3.run(430);
        d3.swim(0);

        System.out.println("Всього тварин: " + Animal.getCount());
        System.out.println("Всього котів: " + Cat.getCatCount());
        System.out.println("Всього собак: " + Dog.getDogCount());

    }
}
