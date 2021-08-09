// 二叉树的直径
public class Hot543 {
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

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode node){
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
