// 目标和
public class Hot494 {
    // 同一套背包框架代码，01背包
    public int findTargetSumWays(int[] nums, int target) {
        // target = 正数和 - 负数和 = x - y
        // sum = 正数和 + 负数和 = x + y
        // 正数和 = (sum + target) / 2，可能存在整数溢出，故取负数和 = (sum - target) / 2
        int sum = 0;
        for (int num : nums) sum += num;
        if (target > sum || (sum - target) % 2 == 1) return 0;
        int S = (sum - target) / 2;
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
