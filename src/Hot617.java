import java.util.Deque;
import java.util.LinkedList;

// 合并二叉树
public class Hot617 {
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

    // dfs
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    // bfs
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root1);
        q.offer(root2);
        while (!q.isEmpty()){
            TreeNode cur1 = q.poll();
            TreeNode cur2 = q.poll();
            cur1.val += cur2.val;
            if (cur1.left != null && cur2.left != null){
                q.offer(cur1.left);
                q.offer(cur2.left);
            } else if (cur1.left == null)
                cur1.left = cur2.left;
            if (cur1.right != null && cur2.right != null){
                q.offer(cur1.right);
                q.offer(cur2.right);
            } else if (cur1.right == null)
                cur1.right = cur2.right;
        }
        return root1;
    }
}
