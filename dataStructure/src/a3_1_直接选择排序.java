import java.util.Arrays;

public class a3_1_直接选择排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        directSelectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *选择类
     * 直接选择排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     * 可用于链式存储结构
     * 不稳定排序
     * 移动记录次数较少
     * 每一记录占用的空间较多时优于直接插入排序
     *
     */
    private static void directSelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[k]) {
                    k = j;
                }
            }
            if(k!=i) {
                int tmp = array[i];
                array[i] = array[k];
                array[k] = tmp;
            }
        }
    }

}
