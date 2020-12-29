package strategy;

/**
 * @author 王文
 * @date 2020/12/19 17:21
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Cat implements Comparable<Cat>{
    int weight,height;
    public Cat (int weight,int height){
        this.weight=weight;
        this.height=height;
    }

    public int compareTo(Cat c){
        if(this.weight<c.weight) return -1;
        else if (this.weight>c.weight) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

}
