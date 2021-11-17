package 代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Tank
 * @description: Jdk动态代理
 * @date 2021-11-17
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("运行中！");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class},
                new TimeTankProxy(tank));

        m.move();
    }
}

class TimeTankProxy implements InvocationHandler {

    Tank tank;

    public TimeTankProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法开始了");
        Object invoke = method.invoke(tank, args);
        System.out.println("方法结束了");
        return invoke;
    }
}

interface Movable {
    void move();
}
