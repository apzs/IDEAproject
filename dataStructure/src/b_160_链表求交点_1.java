import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 给出两个链表，求这两个链表开始相交的节点的值
 */
/*样例输入1:
 1 2 3 4 5 6 7 8 9 0
17 7 8 9 0
样例输入2:
1 2 3 4 5 6 0
7 8 9 0
*/
public class b_160_链表求交点_1 {
    public static void main(String[] args) {
        Queue<Integer> a = new  LinkedList<Integer>();
        Queue<Integer> b = new  LinkedList<Integer>();
        
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        while (e != 0){
            a.offer(e);
            e = sc.nextInt();
        }
        
        e = sc.nextInt();
        while (e!=0){
            b.offer(e);
            e = sc.nextInt();
        }

        int m = a.size();
        int n = b.size();
        int sub = m - n;
        while (sub>0){
            a.poll();
            sub--;
        }
        while (sub<0){
            b.poll();
            sub++;
        }

        int ans=0;
        while (!a.isEmpty()){
            int j = a.poll();
            int k = b.poll();
            if (j == k){
                ans = j;
                break;
            }
        }
        System.out.println(ans);
    }

}
