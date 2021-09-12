import java.util.Arrays;

public class a3_2_堆排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *选择类
     * 堆排序
     * 时间复杂度O(nlong2n)
     * 空间复杂度O(1)
     * 只能用于顺序结构
     * 不稳定排序
     * 记录多时为高效
     *
     */
    private static void heapSort(int[] array) {
        CreateHeap(array);
        for (int i = array.length-1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            HeapAdjust(array, 0, i-1);
        }
    }

    //调整成大根堆
    private static void HeapAdjust(int[] array, int s, int m) {
        int root = array[s];
        for (int i = 2*s+1; i <= m; i= 2*i+1) {
            if(i<m&&array[i]<array[i+1]) {
                i++;
            }
            if(root>=array[i]) {
                break;
            }
            array[s] = array[i];
            s = i;
        }
        array[s] = root;
    }

    //把array建成大根堆
    private static void CreateHeap(int[] array) {
        int n = array.length - 1;
        for (int i = n/2; i >= 0; i--) {
            HeapAdjust(array, i, n);
        }
    }

}
