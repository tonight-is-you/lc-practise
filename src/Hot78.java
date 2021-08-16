import java.util.ArrayList;
import java.util.List;

// 子集
public class Hot78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0)
            return res;
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        dfs(0, nums, ls, n);
        return res;
    }
    private void dfs(int start, int[] nums, List<Integer> ls, int n){
        res.add(ls);
        for (int i = start; i < n; i ++){
            ls.add(nums[i]);
            dfs(i + 1, nums, ls, n);
            ls.remove(ls.size() - 1);
        }
    }
}
