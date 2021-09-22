public class CTT {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode mergeTwo(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (node1 != null && node2 != null){
            if (node1.val <= node2.val){
                cur.next = node1;
                node1 = node1.next;
            }
            else{
                cur.next = node2;
                node2.next = node2;
            }
            cur = cur.next;
        }
        cur.next = node1 == null? node2 : node1;
        return dummy.next;
    }

    public ListNode sortNode(ListNode head){
        if (head == null)
            return head;
        ListNode tmp = head;
        int len = 0;
        while (tmp != null){
            len ++;
            tmp = tmp.next;
        }
        ListNode dummy = new ListNode(0, head);
        for (int subLen = 1; subLen < len; subLen <<= 1){
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null){
                ListNode node1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i ++)
                    cur = cur.next;
                ListNode node2 = cur.next;
                cur.next = null;
                cur = node2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i ++)
                    cur = cur.next;
                ListNode next = null;
                if (cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = mergeTwo(node1, node2);
                prev.next = merged;
                while (prev.next != null)
                    prev = prev.next;
                cur = next;
            }
        }
        return dummy.next;
    }
}
