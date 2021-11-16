package 享元模式;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: Main
 * @description: 享元设计模式（重复利用对象 池技术）
 * @date 2021-11-16
 */
public class Main {

    public static void main(String[] args) {
        String s1="abc";
        String s2="abc";
        String s3=new String("abc");
        String s4=new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern());
        System.out.println(s1.intern() == s3.intern());
    }
}
