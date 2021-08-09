import java.util.Deque;
import java.util.LinkedList;

// 最小栈
public class Hot155 {
    private class MinStack{
        private Deque<Integer> xStack;
        private Deque<Integer> minStack;

        public MinStack(){
            this.xStack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }
        public void push(int val) {
            xStack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
