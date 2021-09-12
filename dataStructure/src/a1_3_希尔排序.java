import java.util.Arrays;

public class a1_3_希尔排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        ShellSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *插入类
     * 希尔排序
     * 时间复杂度O(n的1.3次方)
     * 空间复杂度O(1)
     * 记录跳跃式移动导致不稳定排序
     * 适合初始记录无序、n较大的情况
     *
     */
    private static void ShellSort(int[] array) {
        //定义增量数组
        int dt[] = {5, 3, 1};
        for (int i = 0; i < dt.length; i++) {
            ShellInsert(array, dt[i]);
        }
    }

    private static void ShellInsert(int[] array, int t) {
        for (int i = t; i < array.length; i++) {
            if(array[i] < array[i-t]) {
                int tmp = array[i];
                int j;

                for (j = i-t; (j>=0)&&(tmp < array[j]); j -= t) {
                    array[j+t] = array[j];
                }

                array[j+t] = tmp;
            }
        }
    }

}
