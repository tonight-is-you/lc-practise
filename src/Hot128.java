import java.util.HashSet;
import java.util.Set;

// 最长连续序列
public class Hot128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
