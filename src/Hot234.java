// 回文链表判断
public class Hot234 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 翻转链表
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // find middle
    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        mid.next = reverse(mid.next);

        ListNode back = mid.next;
        while (back != null){
            if (head.val != back.val)
                return false;
            head = head.next;
            back = back.next;
        }
        return true;
    }
}
