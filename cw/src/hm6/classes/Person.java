package hm6.classes;

import hm6.interfaces.Member;

public class Person implements Member {
    private String name;
    private int runLimitation = 500;
    private int jumpLimitation = 5;

    public Person() {
        name = " Person";
    }

    @Override
    public void run() {
        System.out.print("Person runs by ");
    }

    @Override
    public void jump() {
        System.out.print("Person jumps through ");
    }

    @Override
    public void run(int a) {
        if (a <= runLimitation) {
            System.out.print("Person runs " + a + " by ");
        } else System.out.print("A person doesn't run around that much by ");
    }

    @Override
    public void jump(int b) {
        if (b <= jumpLimitation) {
            System.out.print("Person jumps " + b + " through ");
        } else System.out.print("A person doesn't jump around that much  through ");
    }
}
