// 下一个排列，必须 原地 修改，只允许使用额外常数空间
public class Hot31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k = n - 1;
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) k --;
        if (k == 0)
            reverse(nums, 0, n - 1);
        else{
            int u = k;
            while (u + 1 < n && nums[u + 1] > nums[k - 1]) u ++;
            swap(nums, k - 1, u);
            reverse(nums, k, n - 1);
        }
    }

    private void reverse(int[] arr, int l, int r){
        while (l < r){
            swap(arr, l, r);
            l ++;
            r --;
        }
    }

    private void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
