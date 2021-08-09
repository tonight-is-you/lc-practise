import java.util.HashSet;
import java.util.Set;

// 相交链表
public class Hot160 {

      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
      // O(1)空间复杂度，我吹你吹过的晚风，我喝你喝过的西北风
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if (headA == null || headB == null)
              return null;
          ListNode pA = headA, pB = headB;
          while (pA != pB){
              pA = pA == null ? headB : pA.next;
              pB = pB == null ? headA : pB.next;
          }
          return pA;
      }
      // O(n)空间复杂度
      public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
          if (headA == null || headB == null)
              return null;
          Set<ListNode> set = new HashSet<>();
          ListNode temp = headA;
          while (temp != null){
              set.add(temp);
              temp = temp.next;
          }
          temp = headB;
          while (temp != null){
              if (set.contains(temp))
                  return temp;
              temp = temp.next;
          }
          return null;
      }
}
