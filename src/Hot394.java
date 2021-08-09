import java.util.Stack;
// 字符串解码
public class Hot394 {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<Integer>();
        StringBuilder ans = new StringBuilder();
        Stack<StringBuilder> ansStack = new Stack<>();
        int m = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c))
                m = m * 10 + c - '0';
            else if (c == '['){
                ansStack.push(ans);
                num.push(m);
                ans = new StringBuilder();
                m = 0;
            }
            else if (Character.isAlphabetic(c))
                ans.append(c);
            else if (c == ']'){
                StringBuilder tmpSb = ansStack.pop();
                int n = num.pop();
                for (int i = 0; i < n; i ++)
                    tmpSb.append(ans);
                ans = tmpSb;
            }
        }
        return ans.toString();
    }
}
