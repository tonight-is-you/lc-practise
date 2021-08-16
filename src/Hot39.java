import java.util.ArrayList;
import java.util.List;

// 组合总和
public class Hot39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0 || target < 0)
            return res;
        List<Integer> candidate = new ArrayList<>();
        dfs(0, candidates, target, candidate);
        return res;
    }
    private void dfs(int index, int[] candidates, int target, List<Integer> tmp){
        if (target == 0){
            res.add(new ArrayList<>(tmp));
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i ++){
            tmp.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
