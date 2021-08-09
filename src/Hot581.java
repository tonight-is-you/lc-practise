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
            if (nums[i] < max)
                end = i;
            else
                max = nums[i];

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
        int start = 0, end = -1;
        for (int i = 0; i < n; i ++){
            if (nums[i] != arr[i]){
                start = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--){
            if (nums[i] != arr[i]){
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}
