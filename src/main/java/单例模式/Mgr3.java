package 单例模式;

/**
 * @author 王文
 * @date 2020/12/19 14:21
 * @motto 恢弘志士之气，不宜妄自菲薄
 */

public class Mgr3 {
    private Mgr3() {

    }

    private static class Mgr3Holder {
        private static final Mgr3 INSTANCE = new Mgr3();
    }

    public static Mgr3 getInstance() {
        return Mgr3Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Mgr2 m = Mgr2.getInstance();
                    System.out.println(m.hashCode());
                }
            }).start();
        }

    }
}