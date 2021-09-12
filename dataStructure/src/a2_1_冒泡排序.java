import java.util.Arrays;

public class a2_1_冒泡排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *
     * 冒泡排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     * 可用于链式存储结构
     * 稳定排序
     * 平均时间性能比直接插入排序差
     *
     */
    /**
     *交换类
     * 冒泡排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     * 可用于链式存储结构
     * 稳定排序
     * 平均时间性能比直接插入排序差
     *
     */
    private static void bubbleSort(int[] array) {
        int flag = 1;
        for (int i = array.length - 1; i > 0 && flag == 1; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                    flag = 1;
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

}
