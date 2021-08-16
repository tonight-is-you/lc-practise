import java.util.HashMap;
import java.util.Map;

// 最小覆盖字串
public class Hot76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, valid = 0, start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()){
            char rightChar = s.charAt(right);
            right ++;
            if (need.containsKey(rightChar)){
                window.put(rightChar, window.getOrDefault(rightChar,0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar)))
                    valid ++;
            }

            while (valid == need.size()){
                if (right - left < len){
                    len = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left ++;
                if (need.containsKey(leftChar)){
                    if (need.get(leftChar).equals(window.get(leftChar)))
                        valid --;
                    window.put(leftChar, window.get(leftChar) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }
}
