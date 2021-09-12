import java.util.Arrays;

public class second {

    private static int[] a;
    private static int[] b;

    public static void main(String[] args) {
        a = new int[]{6, 5, 8, 3, 7, 9, 2};
        b = new int[a.length];
        mergeSort(0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int l, int r) {
        if (l<r){
            int mid = (l+r)/2;
            mergeSort(l,mid);
            mergeSort(mid+1,r);
            sort(l,mid,r);
        }
    }

    private static void sort(int l, int mid, int r) {
        int k = l;
        int i = l;
        int j = mid+1;
        while (i<=mid && j<=r){
            if (a[i]<=a[j]) {
                b[k++] = a[i++];
            }else{
                b[k++] = a[j++];
            }
        }
        while (i<=mid){
            b[k++]=a[i++];
        }
        while (j<=r){
            b[k++]=a[j++];
        }
        for (int m = l; m <= r; m++) {
            a[m] = b[m];
        }
    }
}
