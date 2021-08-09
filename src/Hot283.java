// 移动零
public class Hot283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        while (right < len){
            if (nums[right] != 0){
                swap(nums, left, right);
                left ++;
            }
            right ++;
        }
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
