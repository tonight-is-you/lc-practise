// 买卖股票的最佳时机，一次买卖
public class Hot121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    // 动规，郁郁雨模版
    public int maxProfit2(int[] prices) {
        int dp0 = 0;                    // 一直不买
        int dp1 = - prices[0];          // 只买了一次
        int dp2 = Integer.MIN_VALUE;    // 买了一次，卖了一次

        for(int i = 1; i < prices.length; i++){
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
        }
        return Math.max(dp0, dp2);
    }
}
