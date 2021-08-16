import java.util.ArrayList;
import java.util.List;

// 全排列
public class Hot46 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) return res;
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        dfs(nums, ls, n);
        return res;
    }
    private void dfs(int[] nums, List<Integer> tmp, int n){
        if (tmp.size() == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < n; i ++){
            tmp.add(nums[i]);
            dfs(nums, tmp, n);
            tmp.remove(tmp.size() - 1);
        }
    }
}
