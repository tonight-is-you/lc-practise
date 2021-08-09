import java.util.List;

// 排序链表，自底向上的归并排序，要求常数空间复杂度和O（NlogN）时间复杂度
public class Hot148 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 自底向上归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode node = head;
        while (node != null){
            len ++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLen = 1; subLen < len; subLen <<= 1){
            ListNode prev = dummyHead;
            ListNode cur = dummyHead.next;

            while (cur != null){
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i ++)
                    cur = cur.next;

                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i ++)
                    cur = cur.next;

                ListNode next = null;
                if (cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = mergeTwoList(head1, head2);
                prev.next = merged;
                while (prev.next != null){ // 为什么不能是if而必须是while，是因为两个节点合并之后，节点个数没有变为1，还是两个，此时prev的next指向有序链表的头节点
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null? l2 : l1;
        return dummyHead.next;
    }
}
