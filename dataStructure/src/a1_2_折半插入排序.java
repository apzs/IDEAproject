import java.util.Arrays;

public class a1_2_折半插入排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        binaryInsertSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *插入类
     * 折半插入排序
     * 时间复杂度O(n²)
     * 空间复杂度O(1)
     * 稳定排序
     * 适合初始记录无序、n较大的情况
     *
     */
    private static void binaryInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int low = 0;
            int high = array.length-1;

            while (low <= high) {
                int m = (low + high) / 2;
                if(temp < array[m]) {
                    high = m - 1;
                }
                else {
                    low = m + 1;
                }
            }

            int j;
            for (j = i-1; j >= high+1;) {
                array[j+1] = array[j];
                j--;
                if (j<0) {
                    break;
                }
            }
            array[j+1] = temp;

        }
    }

}
