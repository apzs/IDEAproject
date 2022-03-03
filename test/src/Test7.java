import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
public  class Test7 {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(1);
        q.add(30);
        q.add(20);
        q.stream().sorted(Integer::compare);
        for (Integer integer : q) {
            System.out.println(integer);
        }
    }
}
