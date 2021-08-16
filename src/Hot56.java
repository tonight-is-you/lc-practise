import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
public class Hot56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (l, r) -> l[0] - r[0]);
        for (int[] interval : intervals){
            int L = interval[0];
            int R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L)
                merged.add(new int[]{L, R});
            else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
