// 乘积最大连续子数组
public class Hot152 {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF=nums[0], max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i ++){
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            minF = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            max = Math.max(max, maxF);
        }
        return max;
    }
}
