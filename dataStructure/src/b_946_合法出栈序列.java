import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 样例输入1：
 1 2 3 4 0
 3 2 4 1 0
 样例输入2：
 1 2 3 4 0
 3 4 1 2 0
 */
public class b_946_合法出栈序列 {
    public static void main(String[] args) {
        Queue<Integer> a = new  LinkedList<Integer>();
        Queue<Integer> b = new  LinkedList<Integer>();
        Stack<Integer> s = new Stack<Integer>();

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

        int head = a.poll();
        s.push(head);
        while (!a.isEmpty()){
            if(!s.isEmpty()) {
                int stackTop = s.peek();
                if (stackTop == b.peek()) {
                    s.pop();
                    b.poll();
                   continue;
                }
                head = a.poll();
                s.push(head);
            }else {
                head = a.poll();
                s.push(head);
            }
        }
        while (!s.isEmpty() && (s.peek() == b.peek())){
            s.pop();
            b.poll();
        }
        if (s.isEmpty()) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

}
