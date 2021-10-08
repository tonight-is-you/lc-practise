import java.util.Arrays;

// 零钱兑换
public class Hot322 {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i ++){
//            int minCS = Integer.MAX_VALUE;
//            for (int coin : coins){
//                if (coin <= i)
//                    minCS = Math.min(minCS, dp[i-coin] + 1);
//            }
//            dp[i] = minCS == Integer.MAX_VALUE? -1 : minCS;
//        }
//        return dp[amount];
//    }

    // 同一套背包框架代码，本题是完全背包，不考虑顺序
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = 1; i <= amount; i ++){
                if (coin <= i && dp[i - coin] + 1 >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
