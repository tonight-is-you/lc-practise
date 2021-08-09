import java.util.Arrays;

// 完全平方数
public class Hot279 {
//    public int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i ++){
//            dp[i] = i;
//            for (int j = 1; i - j * j >= 0; j ++)
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//        }
//        return dp[n];
//    }

    // 同一套背包问题框架代码，本题属于完全背包，不考虑顺序
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int num = 1; num <= Math.sqrt(n); num ++){
            for (int t = 0; t <= n; t ++){
                if (t >= num * num){
                    dp[t] = Math.min(dp[t], dp[t - num * num] + 1);
                }
            }
        }
        return dp[n];
    }
}
