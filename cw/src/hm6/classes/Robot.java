package hm6.classes;

import hm6.interfaces.Member;

public class Robot implements Member {
    private String name;
    private int runLimitation = 50;
    private  int jumpLimitation = 2;
    public  Robot(){
        name = " Robot";
    }

    @Override
    public void run() {
        System.out.print("Robot runs by ");
    }

    @Override
    public void jump() {
        System.out.print("Robot jumps through ");
    }

    @Override
    public void run(int a) {
        if(a<=runLimitation){
            System.out.print("Robot runs " + a+ " by ");
        } else System.out.print("A Robot doesn't run around that much by");
    }

    @Override
    public void jump(int b) {
        if(b<=jumpLimitation){
            System.out.print("Robot jumps" + b+ " through ");
        } else System.out.print("A Robot doesn't jump around that much through ");
    }
}
