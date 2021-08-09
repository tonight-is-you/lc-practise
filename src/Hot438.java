import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 找到字符串中所有字母异位词
public class Hot438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length();
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] pSnt = new int[26];
        int[] sSnt = new int[26];
        for (int i = 0; i < m; i ++){
            pSnt[p.charAt(i) - 'a'] ++;
            sSnt[s.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(pSnt, sSnt))
            res.add(0);
        for (int i = m; i < s.length(); i ++){
            sSnt[s.charAt(i - m) - 'a'] --;
            sSnt[s.charAt(i) - 'a'] ++;
            if (Arrays.equals(pSnt, sSnt))
                res.add(i - m + 1);
        }
        return res;
    }
}
