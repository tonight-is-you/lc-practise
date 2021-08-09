//  回文子串
public class Hot647 {
    // 扩展中心法
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i ++){
            ans += spread(s, i, i);
            ans += spread(s, i, i + 1);
        }
        return ans;
    }
    private int spread(String s, int l, int r){
        int cnt = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            cnt ++;
            l --;
            r ++;
        }
        return cnt;
    }
}
