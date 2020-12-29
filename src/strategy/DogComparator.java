package strategy;

/**
 * @author 王文
 * @date 2020/12/19 18:24
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.food<o2.food) return -1;
        else if (o1.food>o2.food) return 1;
        return 0;
    }
}
