import java.util.List;

// 单词拆分
public class Hot139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i ++){
            for (int j = 0; j < i; j ++){
                if (wordDict.contains(s.substring(j, i)) && dp[j])
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    // 完全背包，有顺序，统一框架代码
    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i ++){
            for (String word: wordDict){
                int sz = word.length();
                if (i - sz >= 0 && s.substring(i - sz, i).equals(word))
                    dp[i] = dp[i] || dp[i - sz];
            }
        }
        return dp[n];
    }
}
