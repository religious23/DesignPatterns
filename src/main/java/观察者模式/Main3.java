package 观察者模式;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main3
 * @description: 观察者设计模式
 * @date 2021-11-03
 */
public class Main3 {

    static class Dad{
        public void feed(){
            System.out.println("爸爸正在喂饭！");
        }
    }

    static class Child{
        private boolean cry;
        private Dad d=new Dad();

        private boolean isCry(){
            return cry;
        }

        public void wakeUp(){
            cry=true;
            d.feed();
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
