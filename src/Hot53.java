// 最大子序和
public class Hot53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num: nums){
            if (sum > 0)
                sum += num;
            else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
