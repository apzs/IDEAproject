import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.pow;
/*
10 植树
【问题描述】
小明和朋友们一起去郊外植树，他们带了一些在自己实验室精心研究出的小树苗。
小明和朋友们一共有 n 个人，他们经过精心挑选，在一块空地上每个人挑选了一个适合植树的位置，总共 n 个。
他们准备把自己带的树苗都植下去。
然而，他们遇到了一个困难：
有的树苗比较大，而有的位置挨太近，导致两棵树植下去后会撞在一起。
他们将树看成一个圆，圆心在他们找的位置上。
如果两棵树对应的圆相交，这两棵树就不适合同时植下（相切不受影响），称为两棵树冲突。
小明和朋友们决定先合计合计，只将其中的一部分树植下去，保证没有互相冲突的树。
他们同时希望这些树所能覆盖的面积和（圆面积和）最大。
【输入格式】
输入的第一行包含一个整数 n ，表示人数，即准备植树的位置数。
接下来 n 行，每行三个整数 x, y, r，表示一棵树在空地上的横、纵坐标和半径。
【输出格式】
输出一行包含一个整数，表示在不冲突下可以植树的面积和。
由于每棵树的面积都是圆周率的整数倍，请输出答案除以圆周率后的值（应当是一个整数）。
【样例输入】
6
1 1 2
1 4 2
1 7 2
4 1 2
4 4 2
4 7 2
【样例输出】
12
【评测用例规模与约定】
对于 30% 的评测用例，1 <= n <= 10；
对于 60% 的评测用例，1 <= n <= 20；
对于所有评测用例，1 <= n <= 30，0 <= x, y <= 1000，1 <= r <= 1000。
 */
public class a91_植树 {
    static ArrayList<node> l1 = new ArrayList<>();
    static ArrayList<node> l2 = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            l1.add(new node(x, y, r));
        }
        Collections.sort(l1,(a,b)->a.x+a.y+a.r-b.x-b.y-b.r);
        l2.add(l1.get(0));
        for (int i = 1; i < l1.size(); i++) {
            node no = l1.get(i);
            boolean path = true;
            for (int j = 0; j < l2.size(); j++) {
                node nod = l2.get(j);
                if (pow(nod.x-no.x, 2)+pow(nod.y-no.y, 2) < pow(nod.r+no.r,2) ){
                    path = false;
                    break;
                }
            }
            if (path) l2.add(no);
        }
        System.out.println(l2.size());
        for (node no:l2) {
            System.out.println(no.x+ " "+no.y+" " +no.r);
        }
    }

    static class node{
        int x;
        int y;
        int r;
        public node(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
