public class b_55_跳跃游戏 {
    /**
     *数组内存储在该点时可以跳过的最远距离，求能否跳到终点（即每一步都跳的最远/求最小步数）
     */
    public static void main(String[] args) {
//        int[] a = {4,4,2,3,1,0,0};
        int[] a = {2,3,2,1,0,2,0};
        int i=0;
        int count = 0;
        while (i<a.length){
            count++;
            if (i+a[i]>=a.length-1){
                i = i+a[i];
                break;
            }
            if (a[i] == 0){
                break;
            }
            int max =0;
            int index=0;
            for (int j = 1; j <= a[i]; j++) {
                if (a[i+j]+j >= max){
                    index = j;
                    max = a[i+j]+j;
                }
            }
            i = i+index;
        }
        System.out.println(i);
        System.out.println(count);
    }
}
