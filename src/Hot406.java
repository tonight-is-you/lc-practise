import java.util.Arrays;
import java.util.LinkedList;

// 根据身高重建队列
public class Hot406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0])
                return p2[0] - p1[0];
            else
                return p1[1] - p2[1];
        });
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        return list.toArray(new int[list.size()][2]);
    }
}
