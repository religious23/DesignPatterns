package 观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main4
 * @description: 观察者设计模式
 * @date 2021-11-03
 */
public class Main4 {

    //事件类
    static class wakeUpEvent {
        long timestamp;
        String loc;
        Child source;

        public Child getSource() {
            return source;
        }

        public wakeUpEvent(long timestamp, String loc) {
            this.timestamp = timestamp;
            this.loc = loc;
        }
    }

    static class Dad implements Observer {
        public void feed() {
            System.out.println("爸爸正在喂饭！");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            feed();
        }
    }

    static class Mum implements Observer {
        public void feed() {
            System.out.println("妈妈正在喂饭！");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            feed();
        }
    }

    static class Dog implements Observer {
        public void feed() {
            System.out.println("狗正在叫！");
        }

        @Override
        public void actionOnWakeUp(wakeUpEvent event) {
            feed();
        }
    }

    static class Child {
        private List<Observer> list = new ArrayList<>();
        private boolean cry;

        private void addObserver(Observer observer) {
            this.list.add(observer);
        }

        private boolean isCry() {
            return cry;
        }

        public void wakeUp() {
            cry = true;
            wakeUpEvent event = new wakeUpEvent(1233213, "家里");
            for (Observer observer : list) {
                observer.actionOnWakeUp(event);
            }
        }
    }

    interface Observer {
        void actionOnWakeUp(wakeUpEvent event);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.addObserver(new Dad());
        child.addObserver(new Mum());
        child.addObserver(new Dog());
        child.wakeUp();
    }
}
