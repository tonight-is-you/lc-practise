import java.util.*;
import java.util.LinkedList;

public class traversal {
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

    /* 前序遍历模版
    栈S;
    p= root;
    while(p || S不空){
        while(p){
            访问p节点；
            p的右子树入S;
            p = p的左子树;
        }
        p = S栈顶弹出;
     */
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }
        return res;
    }

    /* 后序遍历模版
    栈S;
    p= root;
    while(p || S不空){
        while(p){
            访问p节点；
            p的左子树入S;
            p = p的右子树;
        }
        p = S栈顶弹出;
    }
    结果序列逆序;
    */
    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root.left);
                root = root.right;
            }
            root = stack.pop();
        }
        Collections.reverse(res); // O(n)时间复杂度
        return res;
    }

    /* 中序遍历模版
    栈S;
    p= root;
    while(p || S不空){
        while(p){
            p入S;
            p = p的左子树;
        }
        p = S.pop 出栈;
        访问p;
        p = p的右子树;
    }
    */
    public List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 层序遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> ls = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ls.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(ls);
        }
        return res;
    }
}
