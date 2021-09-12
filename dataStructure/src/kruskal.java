import java.util.Arrays;

public class kruskal {

    static class Graph {
        Edge[] edges;
        int[][] arr;
    }
    static class Edge implements Comparable<Edge> {
        int begin;
        int end;
        int weight;
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }

    public static void kruskal(Graph graph) {
        //从小到大按权值排好序的edges
        Edge[] edges = graph.edges;
        int[][] arr = graph.arr;
        int[] parent = new int[7];
        //顶点的编号为0-6
        for(int i =0;i<7;i++){
            parent[i] = 0;
        }
        for(int i=0;i<edges.length;i++){
            Edge edge = edges[i];
            int rootOfBegin = findParentRoot(edge.begin, parent);
            int rootOfend = findParentRoot(edge.end, parent);
            if(rootOfBegin!=rootOfend){
                System.out.println(String.format("(%d,%d)->%d", rootOfBegin,rootOfend,edge.weight));
                parent[rootOfBegin] = rootOfend;
            }
        }
    }
    //parent数组用于构造MST判断是否存在环路
	/*判断的思想:
		1.初始化的时候，数组为[0,0,...,0]
		2.第一次循环进来的时候比如(begin=0,end=1,weight=5),由于数组全为0,故返回0和1,
		      若begin和end的返回值不相等则设置parent[begin]=end,即设置了0的双亲节点是1,即把0节点和1节点加入MST
		      当数组数据为[1,5,8,7,7,8,0,0,6]时
		      表示[节点0连着1,1连着5,5连着8,8连着6,2连着8]以及[3连着7,4连着7]
		      若在加入<5,6时>，通过数组找到相同的顶点的话就说明构成了一个环
		3.begin和end的返回值相等，则表示构成了环
	*/
    private static int findParentRoot(int target,int[] parent){
        while(parent[target] > 0){
            target = parent[target];
        }
        return target;
    }

    public static void main(String[] args) {
        //初始化
        Graph graph = new Graph();
        int[][] arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
                else {
                    arr[j][i] = Integer.MAX_VALUE;
                }
            }
        }
        arr[0][1] = 7;
        arr[0][3] = 5;
        arr[1][2] = 8;
        arr[1][3] = 9;
        arr[1][4] = 7;
        arr[2][4] = 5;
        arr[3][4] = 15;
        arr[3][5] = 6;
        arr[4][5] = 8;
        arr[4][6] = 9;
        arr[5][6] = 11;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                arr[j][i] = arr[i][j];
            }
        }
        graph.arr = arr;
        int k = 0;
        Edge[] edges = new Edge[11];
        for(int i=0;i<edges.length;i++){
            Edge edge = new Edge();
            edges[i] = edge;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 7; j++) {
                if (arr[i][j] < Integer.MAX_VALUE) {
                    edges[k].begin = i; // 编号较小的结点为首
                    edges[k].end = j; // 编号较大的结点为尾
                    edges[k].weight = arr[i][j];
                    k++;
                }
            }
        }
        graph.edges = edges;
        Arrays.sort(edges);
        //初始化结束
        kruskal(graph);
    }
}

