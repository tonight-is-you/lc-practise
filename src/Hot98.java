import java.util.Deque;
import java.util.LinkedList;

// 验证二叉搜索树
public class Hot98 {
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

    // 中序遍历
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inOrder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder)
                return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }
}
