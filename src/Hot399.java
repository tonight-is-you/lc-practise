import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 除法求值，并查集
public class Hot399 {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        int n = equations.size();
        UnionFind uf = new UnionFind(2 * n);
        // 预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(2 * n);
        int i = 0;
        for (int j = 0; j < n; j ++){
            List<String> eq = equations.get(j);
            String val1 = eq.get(0);
            String val2 = eq.get(1);
            if (!map.containsKey(val1)){
                map.put(val1, i);
                i ++;
            }
            if (!map.containsKey(val2)){
                map.put(val2, i);
                i ++;
            }
            uf.unionElements(map.get(val1), map.get(val2), values[j]);
        }
        // 查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int k = 0; k < queriesSize; k ++){
            List<String> q = queries.get(k);
            String val1 = q.get(0);
            String val2 = q.get(1);

            Integer id1 = map.get(val1);
            Integer id2 = map.get(val2);
            if (id1 == null || id2 == null)
                res[k] = -1.0d;
            else
                res[k] = uf.isConnected(id1, id2);
        }
        return res;
    }

    private class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i ++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void unionElements(int x, int y, double val){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return;
            parent[xRoot] = yRoot;
            weight[xRoot] = weight[y] * val / weight[x];
        }

        private int find(int x){
            if (x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return weight[x] / weight[y];
            else
                return -1.0d;
        }
    }
}
