import java.util.Random;

// 属于同一类问题，快排解决
public class SelectK {
    // 求第K小的元素；求第K大的元素，相当于求第arr.length - k小的元素
    public int selectK(int[] arr, int k){
        Random rnd = new Random();
        return selectK(arr, 0, arr.length - 1, k, rnd);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rnd){
        int p = partition(arr, l, r, rnd);
        if (p == k) return arr[p];
        if (k < p) return selectK(arr, l, p - 1, k, rnd);
        return selectK(arr, p + 1, r, k, rnd);
    }

    public int partition(int[] arr, int l, int r, Random rnd){
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, p, l);

        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l])
                i ++;
            while (j >= i && arr[j] > arr[l])
                j --;
            if (i >= j) break;
            swap(arr, i, j);
            i ++;
            j --;
        }
        swap(arr, j, l);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
