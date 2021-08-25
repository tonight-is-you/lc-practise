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
        int dp0 = 0;                    // 一直不买，一直为0
        int dp1 = -prices[0];          // 只买了一次
        int dp2 = Integer.MIN_VALUE;    // 买了一次，卖了一次

        for(int i = 1; i < prices.length; i++){
            dp1 = Math.max(dp1, dp0 - prices[i]);  // 前一天也是dp1状态，或者前一天是dp0状态，今天买入一笔变成dp1状态
            dp2 = Math.max(dp2, dp1 + prices[i]); // 前一天也是dp2状态，或者前一天是dp1状态，今天卖出一笔变成dp2状态
        }
        return Math.max(dp0, dp2); // 最后一定是手里没有股票赚的钱最多
    }
}
