import java.util.ArrayList;
import java.util.List;

// 二叉树展开为链表
public class Hot114 {
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
    
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        // 核心代码
        for (int i = 1; i < list.size(); i ++){
            TreeNode pre = list.get(i - 1), cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> ls){
        if (root == null)
            return;
        ls.add(root);
        preOrder(root.left, ls);
        preOrder(root.right, ls);
    }
}
