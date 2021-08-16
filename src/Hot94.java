import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 二叉树的中序遍历
public class Hot94 {
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
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }
    private void inOrder(TreeNode node, List<Integer> ls){
        if (node == null)
            return;
        inOrder(node.left, ls);
        ls.add(node.val);
        inOrder(node.right, ls);
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
