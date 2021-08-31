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
        maxDepth(root);
        return res - 1; // 长度 = 节点数 - 1，即res - 1
    }
    // 如果仅有一个节点，且不为NULL，则该节点深度为1
    private int maxDepth(TreeNode node){
        if (node == null)
            return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        res = Math.max(res, left + right + 1); // 节点数
        return Math.max(left, right) + 1;
    }
}
