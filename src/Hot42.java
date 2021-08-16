// 接雨水
public class Hot42 {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 1; i < n - 1; i ++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        for (int i = n - 2; i > 0; i --)
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        for (int i = 1; i < n - 1; i ++){
            int m = Math.min(maxLeft[i], maxRight[i]);
            if (m > height[i])
                res += m - height[i];
        }
        return res;
    }
}
