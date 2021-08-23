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
        for (int L = 2; L <= len; L ++){ // 遍历每个Len
            for (int i = 0; i < len - 1; i ++){ // i 总是从0开始，len-2结束，由于L是从2开始的，所有i取不到len-1，或者说取到了也没有意义
                int j = i + L - 1; // 右指针
                if (j >= len)
                    break;
                if (cc[i] != cc[j])
                    dp[i][j] = false;
                else {
                    if (j - i + 1 <= 3)
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
