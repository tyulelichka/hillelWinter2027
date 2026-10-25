package hm6.classes;

import hm6.interfaces.Member;
import hm6.interfaces.Obstacle;

public class Wall implements Obstacle {
    @Override
    public void overcome(Member member) {
        member.jump();
        System.out.println("wall");
    }

    @Override
    public void overcomeLimitation(Member member, int a) {
        member.jump(a);
        System.out.println("wall");
    }
}
