import java.util.Arrays;

// 最长递增子序列
public class Hot300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 每个元素都至少可以单独成为子序列
        int maxL = 1;
        for (int i = 0; i < nums.length; i ++){
            for (int j = 0; j < i; j ++){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }
}
