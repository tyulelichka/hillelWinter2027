package hm5.animal;

public class Animal {
    protected String name;
    private static int count = 0;

    public Animal() {
        count++;
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public void run(int distance) {
        if (distance < 0) {
            System.out.println("Відстань не може бути негативна");
        } else System.out.println("Тварина " +getName() + " пробігла:" + distance + "m");
    }

    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Відстань не може бути негативна");
        } else System.out.println("Тварина " +getName() + "  пропливла:" + distance);
    }


}
