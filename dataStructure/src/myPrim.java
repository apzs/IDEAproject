import java.util.Scanner;

public class myPrim {
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
            arr[head-1][tail-1] = value;
            arr[tail-1][head-1] = value;
        }
        sc.close();
        dijstra(arr);
    }

    private static void dijstra(int[][] arr) {
        //求所求点到其他各点的最短路径
        int[] shortestPath = new int[node];
        //记录该节点的头结点
        int[] head = new int[node];
        //初始化
        for (int i = 0; i < node; i++) {
            shortestPath[i] = arr[0][i];
            head[i] = 0;
        }
        shortestPath[0] = 0;
        //判断某是否已经加入最短路径集合
        boolean[] visit = new boolean[node];
        visit[0] = true;

        for (int i = 1; i < node; i++) {
            int value = Integer.MAX_VALUE; //求这一趟更新后的最小值和最小值的坐标
            int index = -1;
            for (int j = 1; j < node; j++) {
                if (!visit[j] && shortestPath[j] < value) {
                    value = shortestPath[j];
                    index = j;
                }
            }
            shortestPath[index] = value;
            visit[index] = true;
            System.out.println(head[index]+1+ "--" + (index+1));
            //加入节点minValueIndex后，更新 V集合->(其他各点) 的代价
            for (int j = 0; j < node; j++) {
                if (!visit[j] && arr[index][j] < shortestPath[j]){
                    shortestPath[j] = arr[index][j];
                    head[j] = index;
                }
            }
        }
    }
}
