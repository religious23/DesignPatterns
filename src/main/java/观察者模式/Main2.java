package 观察者模式;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main2
 * @description: 观察者设计模式
 * @date 2021-11-03
 */
public class Main2 {

    static class Child{
        private boolean cry;

        private boolean isCry(){
            return cry;
        }

        public void wakeUp(){
            System.out.println("小孩醒了，在哭");
            cry=true;
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        while(!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}
