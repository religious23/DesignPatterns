package singleton;

/**
 * @author 王文
 * @date 2020/12/19 14:27
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public enum Mgr4 {
    INSTANCE;

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
