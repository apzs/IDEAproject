import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class myKruskal {
    /*
    样例输入
    6 10
    1 3 1
    1 4 5
    1 2 6
    2 5 3
    3 5 6
    3 6 4
    4 6 2
    5 6 6
    2 3 5
    3 4 5
    */
    private static int node;
    private static int edge;
    private static int maxValue = Integer.MAX_VALUE/2;
    private static ArrayList<Edge> list;
    private static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //节点数
        node = sc.nextInt();
        //边数
        edge = sc.nextInt();
        list = new ArrayList<Edge>();
        int[][] arr = new int[node][node];
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                arr[i][j] = maxValue;
            }
        }

        for (int i = 0; i < edge; i++) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            int value = sc.nextInt();
            arr[head-1][tail-1] = value;
            arr[tail-1][head-1] = value;
            list.add(new Edge(head-1,tail-1,value));
        }
        sc.close();
        Collections.sort(list,(a,b)->a.value-b.value);
//        list.forEach(e -> System.out.println(e.x+ " " + e.y + " " +e.value));
        kruskal(arr);
    }

    private static void kruskal(int[][] arr) {
        //记录所选择点
        int[] point = new int[node];
        p = new int[node];
        int res = 0;
        int cnt= 0;
        for (int i = 0; i < node; i++) {
            p[i] = i;
        }
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            int x = edge.x;
            int y = edge.y;
            int value =edge.value;
            int a=find(x);
            int b=find(y);
            if (a!=b){
               p[a] = b;
               res+=value;
                System.out.println(" " + a+ " "+ b );
            }
        }

    }

    private static int find(int x) {
        if(x!=p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static class Edge{
        int x;
        int y;
        int value;

        public Edge(int x, int y,int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

//        @Override
//        public int compareTo(@NotNull Edge o) {
//            return this.value-o.value;
//        }
    }
}
