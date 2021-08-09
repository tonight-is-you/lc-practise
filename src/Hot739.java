import java.util.Deque;
import java.util.LinkedList;

// 每日温度
public class Hot739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i ++){
            int tp = temperatures[i];
            while (!stack.isEmpty() && tp > temperatures[stack.peek()]){
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}
