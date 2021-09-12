import java.util.Arrays;

public class a3_3_归并排序 {
    public static void main(String[] args) {
        int[] array = {19,32,12,35,65,33};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     *选择类
     * 归并排序
     * 时间复杂度O(nlong2n)
     * 空间复杂度O(n)
     * 可用于链式结构
     * 稳定排序
     *
     */
    private static void mergeSort(int[] array) {
        Msort(array, array, 0, array.length-1);
    }

    private static void Msort(int[] R, int[] T, int low, int high) {
        int[] S = new int[R.length];
        if(low == high) {
            T[low] = R[low];
        } else {
            int mid = (low + high) / 2;
            Msort(R, S, low, mid);
            Msort(R, S, mid+1, high);
            Merge(S, T, low, mid, high);
        }
    }

    private static void Merge(int[] R, int[] T, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i<=mid&&j<=high) {
            if(R[i]<=R[j]) {
                T[k++] = R[i++];
            } else {
                T[k++] = R[j++];
            }
        }
        while (i<=mid) {
            T[k++] = R[i++];
        }
        while (j<=high) {
            T[k++] = R[j++];
        }
    }

}
