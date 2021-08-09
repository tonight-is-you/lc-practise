// 目标和
public class Hot494 {
    // 同一套背包框架代码，01背包
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (target > sum || (target + sum) % 2 == 1) return 0;
        int S = (sum + target) / 2;
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums){
            for (int t = S; t >= 0; t --){
                if (t >= num)
                    dp[t] = dp[t] + dp[t - num];
            }
        }
        return dp[S];
    }
}
