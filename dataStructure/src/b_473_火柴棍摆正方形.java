import java.util.Arrays;

public class b_473_火柴棍摆正方形 {
    private static int[] a;
    private static int avg;

    public static void main(String[] args) {
//        int[][] ans = {{5,5},{1,3},{2,3}};
        Integer[] ans = {5,3,2,1,4,5};
//        Integer[] ans = {1,2,3,4,5,5};
//        Arrays.sort(ans,(a,b)->b[0]-a[0]);
        Arrays.sort(ans,(a,b)->(b-a));
        a = new int[ans.length];
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            a[i] = ans[i];
            sum+=ans[i];
        }
        System.out.println(Arrays.toString(a));
        if(a.length<4){
            System.out.println(false);
        }else if (sum%4!=0){
            System.out.println(false);
        }else {
            avg = sum/4;
            int[] bucket = new int[a.length];
            System.out.println(backTrack(0,bucket));
        }
    }

    /**
     * 回溯法求摆放方法
     * @param i 当前火柴下标,从0开始
     * @param bucket 四个桶（正方形四条边）内以放火柴长度
     * @return
     */
    private static boolean backTrack(int i,int[] bucket){
        //i>a.length表示所有火柴已放完
        if (i>=a.length){
            return true;
        }
        //遍历四个桶，寻找可以放该火柴的桶
        for (int j = 0; j < a.length; j++) {
            if (bucket[j] + a[i] > avg){
                continue;
            }
            bucket[j]+=a[i];
            //如果这个火柴放置到该桶时，下一根火柴放置成功直接返回true
            boolean res = backTrack(i+1,bucket);
            if(res == true){
                return true;
            };
            //如果不成功这将该火柴从该桶中取出，继续尝试放置到下一个桶中
            bucket[j]-=a[i];
        }
        //如果所有桶中都无法放置，返回false，这将上一根火柴从桶中取出，继续尝试放置到下一个桶中
        return false;
    }
}
