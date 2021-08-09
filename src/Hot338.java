// 比特为计数，O（N）的时间和空间复杂度
public class Hot338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i ++){
            if ((i&1) == 0) // 偶数
                dp[i] = dp[i>>1];
            else
                dp[i] = dp[i - 1] + 1;
        }
        return dp;
    }
}
