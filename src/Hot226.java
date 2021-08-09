import java.util.Deque;
import java.util.LinkedList;

// 翻转二叉树
public class Hot226 {
    public class TreeNode {
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
    // DFS递归实现，后续遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // BFS实现
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;

            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        return root;
    }
}
