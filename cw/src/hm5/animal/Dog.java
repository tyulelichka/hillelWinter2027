package hm5.animal;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public void setName(String name) {
        this.name = name;

    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака " + getName() + "  не бігає більше 500 м");
        } else if (distance < 0) {
            System.out.println("Відстань не можу бути негативна");
        } else System.out.println("Собака " + getName() + " пробіг:" + distance + " m");
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака " + getName() + "  не плаває більше 10 м");
        } else if (distance < 0) {
            System.out.println("Відстань не може бути негативна");
        } else System.out.println("Собака " + getName() + " проплив: " + distance + " m");
    }
}
