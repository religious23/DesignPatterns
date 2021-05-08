package singleton;

/**
 * @author 王文
 * @date 2020/12/19 14:11
 * @motto 恢弘志士之气，不宜妄自菲薄
 */

public class Mgr2 {
    private volatile static Mgr2 INSTANCE;

    private Mgr2() {
    }

    public static Mgr2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr2();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
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
