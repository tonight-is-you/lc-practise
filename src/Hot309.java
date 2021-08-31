// 最佳买卖股票时期含冷冻期
public class Hot309 {
    public int maxProfit(int[] prices) {
        int dp0 = 0; // 手里没股票，没有处于冷冻期
        int dp1 = Integer.MIN_VALUE; // 手里没股票，处于冷冻期
        int dp2 = -prices[0]; // 手里有股票
        for (int i = 1; i < prices.length; i++) {
            int new_dp0 = Math.max(dp0, dp1);
            int new_dp1 = dp2 + prices[i];
            int new_dp2 = Math.max(dp0 - prices[i], dp2);
            dp0 = new_dp0;
            dp1 = new_dp1;
            dp2 = new_dp2;
        }
        return Math.max(dp0, dp1);
    }
}
