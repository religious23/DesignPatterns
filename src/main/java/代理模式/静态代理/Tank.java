package 代理模式.静态代理;

import java.util.Random;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Tank
 * @description: 静态代理
 * @date 2021-11-16
 */
public class Tank {
    interface Movable {
        void move();
    }

    static class Tank1 implements Movable {
        @Override
        public void move() {
            System.out.println("运行中！");
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TankTimeProxy implements Movable {
        Movable m;

        public TankTimeProxy(Movable m) {
            this.m = m;
        }

        @Override
        public void move() {
            long start = System.currentTimeMillis();
            m.move();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    static class TankLogProxy implements Movable {

        Movable m;

        public TankLogProxy(Movable m) {
            this.m = m;
        }

        @Override
        public void move() {
            System.out.println("开始！");
            m.move();
            System.out.println("结束！");
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank1())).move();
    }
}
