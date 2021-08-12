// 最长回文字串
public class Hot5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i ++)
            dp[i][i] = true;
        char[] cc = s.toCharArray();
        int begin = 0;
        int maxL = 1;
        for (int L = 2; L <= len; L ++){
            for (int i = 0; i < len - 1; i ++){
                int j = i + L - 1;
                if (j >= len)
                    break;
                if (cc[i] != cc[j])
                    dp[i][j] = false;
                else {
                    if (j - i + 1 < 4)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxL){
                    maxL = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxL);
    }
}
