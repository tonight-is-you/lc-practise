import java.util.PriorityQueue;

// 滑动窗口的最大值
public class Hot239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] != p2[0]? p2[0] - p1[0] : p2[1] - p1[1]);
        for (int i = 0; i < k; i ++)
            queue.offer(new int[]{nums[i], i});
        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; i ++){
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k)
                queue.poll();
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
