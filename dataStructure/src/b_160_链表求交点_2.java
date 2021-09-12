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
public class b_160_链表求交点_2 {
    public static void main(String[] args) {
        //两个链表的头节点b
        //aHead，bHead节点存储链表的长度
        node aHead = new node(0);
        node bHead = new node(0);

        node p1=aHead,p2=bHead;
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        //输入为0时表示该链表结束
        while (e != 0){
            node tmp = new node(e);
            p1.next = tmp;
            //aHead节点存储链表的长度
            aHead.value++;
            p1 = p1.next;
            e = sc.nextInt();
        }

        e = sc.nextInt();
        while (e != 0){
            node tmp = new node(e);
            p2.next = tmp;
            //bHead节点存储链表的长度
            bHead.value++;
            p2 = p2.next;
            e = sc.nextInt();
        }

        int m = aHead.value;
        int n = bHead.value;
        p1=aHead.next;
        p2=bHead.next;
        //将aHead或bHead抛弃前面一部分，使两个链表长度相等
        int sub = m - n;
        while (sub>0){
            p1 = p1.next;
            sub--;
        }
        while (sub<0){
            p2 = p2.next;
            sub++;
        }
        //查找两个节点相交的节点
        int ans=0;
        while (p1.next!=null){
            int j = p1.value;
            int k = p2.value;
            if (j == k){
                ans = j;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(ans);
//        p2=bHead.next;
//        while (p2!=null){
//            System.out.println(p2.value);
//            p2 = p2.next;
//        }
    }

    private static class node{
        int value;
        node next;

        public node(int value) {
            this.value = value;
            this.next=null;
        }
    }
}
