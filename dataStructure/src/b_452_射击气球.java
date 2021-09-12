import java.util.Arrays;
import java.util.Scanner;

/**
 样例输入1：
     5
     1 4
     3 5
     6 8
     4 9
     4 8
 样例输入2：
     4
     1 6
     2 8
     7 12
     10 16
 */
public class b_452_射击气球 {
    public static void main(String[] args) {
        int[][] a;
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        a = new int[count][2];
        for (int i = 0; i < count; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a,(m,n)->m[0]-n[0]);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][0]+" "+a[i][1]);
        }
        //把所有气球都射击完
        int ans = 1;
        int low=a[0][0];
        int high=a[0][1];
        for (int i = 1; i < count; i++) {
            //如果下一个气球可以加入到该次射击，更行射击范围
            if (a[i][0]<=high){
                if (a[i][0]>low){
                    low = a[i][0];
                }
                if (a[i][1]<high){
                    high = a[i][1];
                }
            }else{
                ans++;
                low  = a[i][0];
                high = Integer.MAX_VALUE;
            }
        }
        System.out.println(ans);
    }
}
