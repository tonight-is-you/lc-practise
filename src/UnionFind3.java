// 基于以i为根的集合所表示的树的高度进行合并 + 路径压缩
public class UnionFind3 implements UF{
    private int[] parent;
    private int[] rank;
    public UnionFind3(int size){
        parent = new int[size];
        rank = new int[size];  // rank[i] 表示以i为根的集合所表示的树的高度
        for (int i = 0; i < parent.length; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }
    // O(h)复杂度，h为树的高度
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        // 非递归实现，并不是所有节点都指向根
//        while (p != parent[p])
//            parent[p] = parent[parent[p]]; // 路径压缩
//            p = parent[p];
        // 递归实现，所有节点都指向根，性能比非递归方式差一点点
        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // O(h)时间复杂度，h为树的高度
    @Override
    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
