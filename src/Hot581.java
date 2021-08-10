import java.util.Arrays;

// 最短无序连续子数组
public class Hot581 {
    // O(n)
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int start = 0, end = -1;
        for (int i = 0; i < n; i ++){
            // 从左往右，更新最大值，遇到逆序，更新右边界
            if (nums[i] < max)
                end = i;
            else
                max = nums[i];
            // 从右往左，更新最小值，遇到逆序，更新左边界
            if (nums[n - 1 - i] > min)
                start = n - 1 - i;
            else
                min = nums[n - 1 - i];
        }
        return end - start + 1;
    }
    // O(nlogn)
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }
}
