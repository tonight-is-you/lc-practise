// 移动零
public class Hot283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != 0){
                swap(nums, j, i);
                j ++;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
