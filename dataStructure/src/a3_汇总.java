public class a3_汇总 {

    public static void main(String[] args) {

        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};

        /**
         * InsertSort
         */
//		directInsertSort(array);
//		binaryInsertSort(array);
//		ShellSort(array);


        /**
         * ExchangeSort
         */
        bubbleSort(array);
//		quickSort(array);


        /**
         * SelectSort
         */
//		directSelectionSort(array);
//		heapSort(array);


        /**
         * MergeSort
         */
//		mergeSort(array);

    }


    /**
     *
     * 归并排序
     * 时间复杂度O(nlong2n)
     * 空间复杂度O(n)
     * 可用于链式结构
     * 稳定排序
     *
     */
    private static void mergeSort(int[] array) {
        Msort(array, array, 0, array.length-1);
        printArray(array);
    }

    private static void Msort(int[] R, int[] T, int low, int high) {
        int[] S = new int[R.length];
        if(low == high)
            T[low] = R[low];
        else {
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
            if(R[i]<=R[j])
                T[k++] = R[i++];
            else
                T[k++] = R[j++];
        }
        while (i<=mid)
            T[k++] = R[i++];
        while (j<=high)
            T[k++] = R[j++];
    }


    /**
     *
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
        printArray(array);
    }

    //调整成大根堆
    private static void HeapAdjust(int[] array, int s, int m) {
        int root = array[s];
        for (int i = 2*s+1; i <= m; i= 2*i+1) {
            if(i<m&&array[i]<array[i+1])
                i++;
            if(root>=array[i])
                break;
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


    /**
     *
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
        printArray(array);
    }


    /**
     *
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
        printArray(array);
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
        printArray(array);
    }


    /**
     *
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
        printArray(array);
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


    /**
     *
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

        printArray(array);
    }


    /**
     *
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
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
