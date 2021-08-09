import java.util.HashSet;
import java.util.Set;

// 环形链表2，找出存在入环的节点
public class Hot142 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // O(n)空间复杂度
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode pos = head;
        while (pos != null){
            if (set.contains(pos))
                return pos;
            else{
                set.add(pos);
                pos = pos.next;
            }
        }
        return null;
    }
    // O(1)空间复杂度
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
