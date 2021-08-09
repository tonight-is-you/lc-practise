import java.util.HashMap;
import java.util.Map;

// 多数元素
public class Hot169 {
    // O(1)空间复杂度，摩尔投票法
    public int majorityElement(int[] nums) {
        int cnt = 0;
        Integer cand = null;
        for (int num : nums){
            if (cnt == 0)
                cand = num;
            cnt += cand == num ? 1 : -1;
        }
        return cand;
    }

    // O(n)空间复杂度
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int n = nums.length / 2;
        for (int num : nums){
            if (map.get(num) > n)
                return num;
        }
        return -1;
    }
}
