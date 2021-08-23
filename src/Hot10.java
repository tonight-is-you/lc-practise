// 正则表达式匹配
public class Hot10 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // 往原字符头部插入空格，这样得到 char 数组是从 1 开始，而且可以使得 f[0][0] = true，可以将 true 这个结果滚动下去
        s = " " + s;
        p = " " + p;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        // f(i,j) 代表考虑 s 中的 1~i 字符和 p 中的 1~j 字符 是否匹配
        boolean[][] f = new boolean[n+1][m+1];
        f[0][0] = true;

        /*
         * 完全匹配：f(i, j) = f[i - 1][j - 1] && s[i] == p[j]
         * .匹配：f(i, j) = f[i - 1][j - 1] && p[j] == .
         * *匹配：1）匹配0个前置位字符：f(i, j) = f[i][j - 2]
         *       2) 匹配1个前置位字符：f(i, j) = f[i - 1][j - 2] && (s[i] == p[j - 1] || p[j - 1] == .)，即：f(i-1, j-2) && s[i]匹配p[j-1]
         *       3) 匹配2个前置位字符：f(i, j) = f[i - 2][j - 2] && ((s[i - 1] == p[j - 1] && s[i] == p[j - 1])||p[j - 1] == .)，即：
         *          f(i-2, j-2) && s[i-1:i]匹配p[j-1]
         *       4) 匹配3个前置字符：f(i, j) = f(i-3, j-2) && s[i-2:i]匹配p[j-1]
         *       归纳可得：
         *               f(i,j) = f(i, j-2) || f(i-1, j-2) && s[i]匹配p[j-1] || f(i-2, j-2) && s[i-1:i]匹配p[j-1]...
         *               带入i-1: f(i-1,j) = f(i-1, j-2) || f(i-2, j-2) && s[i-1]匹配p[j-1] || f(i-3, j-2) && s[i-2:i]匹配p[j-1]...
         *       状态转移方程：f(i,j) = f(i,j-2) || f(i-1,j) && s[i]匹配p[j-1]
         * */

        for (int i = 0; i <= n; i ++){ // 因为s字符串前面增加了空格，所有i可以从0开始
            for (int j = 1; j <= m; j ++){  // j 如果从0开始，则f[i][j]必为false，初始化f时已经设为了false，因此j从1开始更好一点
                // 如果下一个字符是 '*'，则代表当前字符不能被单独使用，跳过
                if (j + 1 <= m && pp[j + 1] == '*') continue;
                // 对应了 p[j] 为普通字符和 '.' 的两种情况
                if (i - 1 >= 0 && pp[j] != '*')
                    f[i][j] = f[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '.');
                // 对应了 p[j] 为 '*' 的情况
                else if (pp[j] == '*')
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.'));
            }
        }
        return f[n][m];
    }
}
