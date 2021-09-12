import java.util.Arrays;

public class a2_2_快速排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *交换类
     * 快速排序
     * 时间复杂度O(nlog2n)
     * 空间复杂度最好O(log2n)最差O(n)
     * 需要定位表的上界和下界适合顺序结构
     * 不稳定排序
     * 平均情况是所有内部排序方法中速度最快的一种
     *
     */
    private static void quickSort(int[] array) {
        qSort(array, 0, array.length-1);
    }

    private static void qSort(int[] array, int low, int high) {
        if(low < high) {
            int index = Partition(array, low, high);
            qSort(array, low, index-1);
            qSort(array, index+1, high);
        }
    }

    private static int Partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low<high && array[high]>=tmp) {
                high--;
            }
            array[low] = array[high];

            while (low<high && array[low]<=tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

}
