package strategy;

/**
 * @author 王文
 * @date 2020/12/19 17:13
 * @motto 恢弘志士之气，不宜妄自菲薄
 */
public class Sorter<T> {
    public void sort(T[] a,Comparator<T> comparator) {
        for (int i = 0; i < a.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {
                minPos = comparator.compare(a[j],a[minPos])==-1 ? j : minPos;
            }
            swap(a, i, minPos);
        }
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
