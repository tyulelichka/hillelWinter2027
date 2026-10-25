package hm6.classes;

import hm6.interfaces.Member;
import hm6.interfaces.Obstacle;

public class Treadmill implements Obstacle {
    @Override
    public void overcome(Member member) {
      member.run();
        System.out.println(" treadmill");
    }

    @Override
    public void overcomeLimitation(Member member, int a) {
        member.run(a);
        System.out.println(" treadmill");
    }
}
