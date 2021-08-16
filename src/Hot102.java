import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 二叉树的层序遍历
public class Hot102 {
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
    // 在BFS的应用一：层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i ++){
                TreeNode cur = q.poll();
                ls.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            res.add(ls);
        }
        return res;
    }
}
