package singleton;

/**
 * @author 王文
 * @date 2020/12/19 14:06
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Mgr1 {
    private static final Mgr1 INSTANCE =new Mgr1();
    private Mgr1(){
    }
    public static Mgr1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr1 m1 = Mgr1.getInstance();
        Mgr1 m2 = Mgr1.getInstance();
        System.out.println(m1==m2);
    }
}
