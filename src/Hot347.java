import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 前K个高频元素，时间复杂度必须优于 O(nlogn)
public class Hot347 {
    // 优先队列，用小顶堆存topK
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2) -> p1[1] - p2[1]); //小顶堆，大顶堆是p2[1] - p1[2]
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey(), cnt = entry.getValue();
            if (pq.size() == k){
                if(pq.peek()[1] < cnt){
                    pq.poll();
                    pq.offer(new int[]{num, cnt});
                }
            }
            else
                pq.offer(new int[]{num, cnt});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i ++)
            res[i] = pq.poll()[0];
        return res;
    }
}
