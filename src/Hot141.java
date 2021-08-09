import java.util.HashSet;
import java.util.Set;

// 环形链表，判断是否有环
public class Hot141 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    // O(n)空间复杂度
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null)
            return false;
        while (head != null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 快慢指针，O(1)空间复杂度
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
