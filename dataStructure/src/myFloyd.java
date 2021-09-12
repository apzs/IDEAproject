import java.util.Scanner;

public class myFloyd {

    private static int node;
    private static int edge;
    private static int maxValue = Integer.MAX_VALUE / 2;
    private static int[][] path;

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
        node = sc.nextInt();
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
        floye(arr, source);
    }

    private static void floye(int[][] arr, int source) {

        path = new int[node][node];

        for (int k = 0; k < node; k++) {
            for (int i = 0; i < node; i++) {
                for (int j = 0; j < node; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        print(arr);
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i][j] == maxValue) {
                        System.out.println(i + "->" + j + "不可达");
                    } else {
                        System.out.print(i + "->" + j + " 长度:" + arr[i][j]);
                        System.out.print(" 最短路径：" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }
    }

    private static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == 0){
            return;
        }
        findPath(i,m);
        System.out.print(m+"->");
        findPath(m,j);
    }
}