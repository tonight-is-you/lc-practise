import java.util.HashMap;
import java.util.Map;

// 路径总和3，前缀和+递归
public class Hot437 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, targetSum, map, 0);
    }
    private int dfs(TreeNode node, int target, Map<Integer, Integer> map, int curSum){
        if (node == null)
            return 0;
        curSum += node.val;
        int res = 0;
        res += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += dfs(node.left, target, map, curSum);
        res += dfs(node.right, target, map, curSum);
        map.put(curSum, map.get(curSum) - 1); // 回到本层，需要删除前缀和map中curSum的更新，但不用curSum - node.val，因为dfs传的是值，不是引用
        return res;
    }

    // 560也是前缀和问题
}
