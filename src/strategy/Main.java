package strategy;

import java.util.Arrays;

/**
 * @author 王文
 * @date 2020/12/19 17:03
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Main {
    public static void main(String[] args) {
    Cat[] a={new Cat(3,3),new Cat(1,1), new Cat(5,5)};
    Dog[] b={new Dog(3),new Dog(1), new Dog(5)};
    Sorter sorter =new Sorter();
    sorter.sort(b,new DogComparator());
        System.out.println(Arrays.toString(b));
    }
}
