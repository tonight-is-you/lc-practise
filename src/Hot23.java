// 合并K个升序链表
public class Hot23 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode mergeTwo(ListNode ln1, ListNode ln2){
        ListNode res = new ListNode(-100);
        ListNode dummy = res;
        while(ln1 != null && ln2 != null){
            if (ln1.val <= ln2.val){
                dummy.next = ln1;
                ln1 = ln1.next;
            }
            else{
                dummy.next = ln2;
                ln2 = ln2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (ln1 == null? ln2 : ln1);
        return res.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] ln, int left, int right){
        if (left > right) return null;
        if (left == right) return ln[left];

        int mid = left + (right - left) / 2;
        return mergeTwo(merge(ln, left, mid), merge(ln, mid + 1, right));
    }
}
