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
        preorder(root, list);
        for (int i = 1; i < list.size(); i ++){
            root = list.get(i - 1);
            TreeNode cur = list.get(i);
            root.left = null;
            root.right = cur;
        }
    }
    private void preorder(TreeNode root, List<TreeNode> ls){
        if (root == null)
            return;
        ls.add(root);
        preorder(root.left, ls);
        preorder(root.right, ls);
    }
}
