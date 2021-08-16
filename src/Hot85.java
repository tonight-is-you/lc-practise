// 最大矩形
public class Hot85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[] height = new int[col];
        int res = 0;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            res = Math.max(res, maxRectangle(height));
        }
        return res;
    }
    private int maxRectangle(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        int res = 0;
        for (int i = 1; i < n; i ++){
            int tmp = i - 1;
            while (tmp >= 0 && arr[tmp] >= arr[i])
                tmp = left[tmp];
            left[i] = tmp;
        }
        for (int i = n - 2; i >= 0; i --){
            int tmp = i + 1;
            while (tmp < n && arr[tmp] >= arr[i])
                tmp = right[tmp];
            right[i] = tmp;
        }
        for (int i = 0; i < n; i ++)
            res = Math.max(res, arr[i] * (right[i] - left[i] - 1));
        return res;
    }
}
