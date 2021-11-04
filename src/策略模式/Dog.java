package 策略模式;

/**
 * @author 王文
 * @date 2020/12/19 17:39
 * @motto 恢弘志士之气，不宜妄自菲薄
 */

public class Dog {
    int food;

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    public Dog(int food) {
        this.food = food;
    }
}
