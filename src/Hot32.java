import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 最长有效括号
public class Hot32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
