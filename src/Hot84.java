// 柱形图中最大的矩形
public class Hot84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 向左和向右分别找第一个小于当前高度的下标
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i ++){
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i])
                tmp = left[tmp];
            left[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i --){
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i])
                tmp = right[tmp];
            right[i] = tmp;
        }
        for (int i = 0; i < n; i ++)
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        return res;
    }
}
