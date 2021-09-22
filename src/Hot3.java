import java.util.HashSet;

// 无重复字符的最长子串长度，滑动窗口
public class Hot3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, rk = -1;
        HashSet<Character> occ = new HashSet<>();
        for (int i = 0; i < s.length(); i ++){
            if (i != 0)
                occ.remove(s.charAt(i - 1));
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                rk ++;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }
}
