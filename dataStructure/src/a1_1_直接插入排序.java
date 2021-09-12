import java.util.Arrays;

public class a1_1_直接插入排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        directInsertSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *插入类
     * 直接插入排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     * 稳定排序
     * 适合基本有序情况
     *
     */
    private static void directInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]) {
                int temp = array[i];
                int j;
                for (j = i-1; (j>=0)&&(temp < array[j]); j--) {
                    array[j+1] = array[j];
                }

                array[j+1] = temp;
            }
        }
    }
}
