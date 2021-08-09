// 分割等和子集
public class Hot416 {
    // 01背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums){
            for (int i = target; i >= 1; i --){
                if (i >= num)
                    dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
