import java.util.Scanner;

public class myDijstra {

    private static int node;
    private static int edge;
    private static int maxValue = Integer.MAX_VALUE/2;

    /*
    样例输入
    7 10
    0 1 6
    1 2 5
    0 3 2
    3 1 7
    3 4 5
    1 4 5
    1 5 3
    4 5 5
    5 4 2
    4 6 1
    0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //节点数
        node = sc.nextInt();
        //边数
        edge = sc.nextInt();

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
            arr[head][tail] = value;
        }
        int source = sc.nextInt();
        sc.close();
        dijstra(arr,source);
    }

    private static void dijstra(int[][] arr, int source) {
        //求所求点到其他各点的最短路径
        int[] shortestPath = new int[node];
        for (int i = 0; i < node; i++) {
            shortestPath[i] = arr[source][i];
        }
        //判断某是否已经加入最短路径集合
        boolean[] visit = new boolean[node];
        //记录所求点到其他点的路径
        String[] path = new String[node];
        for (int i = 0; i < path.length; i++) {
            path[i] = source +"->" + i;
        }

        shortestPath[source] = 0;
        visit[source] = true;

        for (int i = 1; i < node; i++) {
            int value = Integer.MAX_VALUE; //求这一趟更新后的最小值和最小值的坐标
            int index = -1;
            for (int j = 0; j < node; j++) {
                if (!visit[j] && shortestPath[j] < value) {
                    value = shortestPath[j];
                    index = j;
                }
            }
            shortestPath[index] = value;
            visit[index] = true;

            //加入节点minValueIndex后，(source)->(minValueIndex)->(其他各点) 的代价
            for (int j = 0; j < node; j++) {
                int newValue = shortestPath[index]+arr[index][j];
                if (!visit[j] && newValue < shortestPath[j]){
                    shortestPath[j] = newValue;
                    path[j] = path[index] + "->" + j;
                }
            }
        }
        print(arr, source, shortestPath, path);
    }

    private static void print(int[][] arr, int source, int[] shortestPath, String[] path) {
        for (int i = 0; i < arr.length; i++) {
            if (i != source) {
                if (shortestPath[i] == maxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + ":" + path[i] + "，距离:" + shortestPath[i]);
                }
            }
        }
    }
}
