import java.util.Arrays;

public class MergeSort {
    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 有序数组时不需要merge，此时整体时间复杂度O(n)
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }
    // 合并两个有序区间arr[l, mid], arr[mid+1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k ++){
            if (i > mid){
                arr[k] = temp[j - l];
                j ++;
            }
            else if(j > r){
                arr[k] = temp[i - l];
                i ++;
            }
            else if (temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l];
                i++;
            }
            else{
                arr[k] = temp[j - l];
                j ++;
            }
        }
    }
}
