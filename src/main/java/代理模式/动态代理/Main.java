package 代理模式.动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main
 * @description: cglib方式生成代理
 * @date 2021-11-17
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank o = (Tank) enhancer.create();
        o.move();
    }
}
    class TimeMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("方法开始了！");
            Object o1 = methodProxy.invokeSuper(o, objects);
            System.out.println("方法结束了！");
            return o1;
        }
    }

