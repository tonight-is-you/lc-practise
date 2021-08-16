import java.util.Map;

// 从前序与中序遍历序列构造二叉树
public class Hot105 {
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

    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i ++)
            indexMap.put(inorder[i], i);
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    private TreeNode build(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight){
        int preRootIndex = preLeft;
        int inRootIndex = indexMap.get(inOrder[preRootIndex]);
        int subLeftNum = inRootIndex - inLeft;
        TreeNode root = new TreeNode(preOrder[preRootIndex]);
        root.left = build(preOrder, inOrder, preLeft + 1, preLeft + subLeftNum, inLeft, inRootIndex - 1);
        root.right = build(preOrder, inOrder, preLeft + subLeftNum + 1, preRight, inRootIndex + 1, inRight);
        return root;
    }
}
