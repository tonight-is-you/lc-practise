import java.util.HashMap;
import java.util.Map;

// 和为K的子数组的数量
public class Hot560 {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i ++){
            pre += nums[i];
            if (map.containsKey(pre - k)) // pre - k 与 pre 之间相差 k
                cnt += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }
}
