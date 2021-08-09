import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 删除无效的括号
public class Hot301 {
    int len = 0;
    public List<String> removeInvalidParentheses(String s) {
        Set<String> all = new HashSet<>();
        int l = 0, r = 0;
        char[] cs = s.toCharArray();
        for (char c : cs){
            if (c == '(')
                l ++;
            else if (c == ')')
                r ++;
        }
        int maxScore = Math.min(l ,r);
        dfs(cs, 0, 0, maxScore, "", all);
        List<String> res = new ArrayList<>();
        for (String ss : all)
            if (ss.length() == len) res.add(ss);
        return res;
    }

    private void dfs(char[] cs, int u, int score, int max, String cur, Set<String> all){
        if (u == cs.length){
            if (score == 0){
                len = Math.max(cur.length(), len);
                all.add(cur);
            }
            return;
        }

        if (cs[u] == '('){
            if (score + 1 <= max) dfs(cs, u + 1, score + 1, max, cur + "(", all);
            dfs(cs, u + 1, score, max, cur, all);
        } else if (cs[u] == ')'){
            if (score - 1 >= 0) dfs(cs, u + 1, score - 1, max, cur + ")", all);
            dfs(cs, u + 1, score, max, cur, all);
        } else
            dfs(cs, u + 1, score, max, cur + cs[u], all);
    }
}
