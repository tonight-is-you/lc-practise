import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Deque;
import java.util.LinkedList;

// 二叉树最大深度
public class Hot104 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // 递归
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 层序遍历
    public int maxDepth2(TreeNode root){
        if (root == null)
            return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()){
            int sz = q.size();
            while (sz > 0){
                TreeNode cur = q.poll();
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
                sz --;
            }
            ans += 1;
        }
        return ans;
    }
}
