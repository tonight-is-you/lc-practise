// 戳气球，【区间DP】求dp[i][j]代码套路就是2层循环起步，第一层是遍历 i 到 j 的宽度，第二层是遍历左端点 i
public class Hot312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for (int i = 0; i < n; i ++)
            temp[i+1] = nums[i];
        // dp[i][j] 表示开区间 (i,j) 内你能拿到的最多金币
        int[][] dp = new int[n+2][n+2];
        for (int len = 3; len <= n + 2; len ++){
            for (int i = 0; i <= n + 2 - len; i ++){
                int maxC = 0;
                for (int k = i + 1; k <= i + len - 2; k ++){ // K表示开区间中最后一戳的位置
                    maxC = Math.max(maxC, temp[i] * temp[k] * temp[i+len-1] + dp[i][k] + dp[k][i+len-1]);
                }
                dp[i][i+len-1] = maxC;
            }
        }
        return dp[0][n+1];
    }
}
