import java.util.ArrayList;
import java.util.List;

// 括号生成
public class Hot22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs(0, 2 * n, 0, n, "", res);
        return res;
    }
    private void dfs(int index, int maxLen, int score, int maxScore, String path, List<String> res){
        if (index == maxLen){
            if (score == 0)
                res.add(path);
        } else {
            if (score + 1 <= maxScore)
                dfs(index + 1, maxLen, score + 1, maxScore, path + "(", res);
            if (score - 1 >= 0)
                dfs(index + 1, maxLen, score - 1, maxScore, path + ")", res);
        }
    }
}
