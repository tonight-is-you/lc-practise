import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 找到字符串中所有字母异位词
public class Hot438 {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length(), n = s.length();
        List<Integer> res = new ArrayList<>();
        if (m > n) return res;
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < m; i ++){
            sCnt[s.charAt(i) - 'a'] ++;
            pCnt[p.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(sCnt, pCnt))
            res.add(0);
        for (int i = m; i < n; i ++){
            sCnt[s.charAt(i - m) - 'a'] --;
            sCnt[s.charAt(i) - 'a'] ++;
            if (Arrays.equals(sCnt, pCnt))
                res.add(i - m + 1);
        }
        return res;
    }
}
