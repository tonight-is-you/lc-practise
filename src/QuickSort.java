import java.util.Random;

public class QuickSort {
    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){
        if (l >= r) return;
        int p = partition(arr, l, r, rnd); // partition2(arr, l, r, rnd)
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }
    // 单路快排，partition是O(n)的时间复杂度，O(1)空间复杂度
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd){
        // 为了解决arr完全有序情况下退化问题（退化为O(n^2）
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        // arr[l + 1, j] < v ; arr[j + 1, r] >= v
        int j = l;
        for (int i = l + 1; i <= r; i ++){
            if (arr[i].compareTo(arr[l]) < 0){
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    // 双路快排，解决当所有元素都相等时，退化为O(n^2)的问题，partition是O(n)的时间复杂度，总体时间复杂度是O（NlogN）
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i].compareTo(arr[l]) < 0)
                i ++;
            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j --;

            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, l, j);
        return j;
    }

    // 三路快排，当所有元素相等时，可以比双路快排更快，使得总体时间复杂度降为O(n)
    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd){
        if (l >= r) return;
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt){
            if (arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, lt, i);
                i ++;
            }
            else if (arr[i].compareTo(arr[l]) > 0){
                gt --;
                swap(arr, gt, i);
            }
            else {
                i++;
            }
        }
        swap(arr, l, lt); // 交换位置之后，lt位置的元素等于v，所以下一次循环不变量的区间端点有调整
        // arr[l, lt - 1] < v, arr[lt, gt - 1] == v, arr[gt, r] > v

        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
