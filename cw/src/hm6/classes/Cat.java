package hm6.classes;

import hm6.interfaces.Member;

public class Cat implements Member {
    private String name;
    private int runLimitation = 200;
    private  int jumpLimitation = 2;
    public Cat(){
        name = "Cat";
    }

    @Override
    public void run() {
        System.out.print("Cat runs by ");
    }

    @Override
    public void jump() {
        System.out.print("Cat jumps through ");
    }

    @Override
    public void run(int a) {
        if(a<=runLimitation){
            System.out.print("Cat runs " + a+ " by ");
        } else System.out.print("A cat doesn't run around that much.");
    }

    @Override
    public void jump(int b) {
        if(b<=jumpLimitation){
            System.out.print("Cat jumps " + b+ " through ");
        } else System.out.print("A cat doesn't jump around that much through ");
    }
}
