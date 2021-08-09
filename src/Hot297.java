import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 二叉树的序列化和反序列化
public class Hot297 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // BFS: Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                res.append("" + cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            else
                res.append("null");
            res.append(",");
        }
        res.append("]");
        return res.toString();
    }
    // BFS: Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (!dataList[i].equals("null")){
                 cur.left = new TreeNode(Integer.parseInt(dataList[i]));
                 queue.offer(cur.left);
            }
            i ++;
            if (!dataList[i].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(cur.right);
            }
            i ++;
        }
        return root;
    }

    // DFS:
    public String serialize2(TreeNode root) {
        if (root == null)
            return "null";
        return root.val + "," + serialize2(root.left) + "," + serialize2(root.right);
    }
    public TreeNode deserialize2(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }
    private TreeNode dfs(Queue<String> queue){
        String val = queue.poll();
        if ("null".equals(val))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }

}
