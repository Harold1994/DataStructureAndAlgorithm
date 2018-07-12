package offer;
import offer.DeleteNodeInO1.ListNode;
//反转链表
public class ReverseList {
    public static ListNode reverse(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.m_pNext;
            if (next == null) {
                reverseHead = node;
            }
            node.m_pNext = prev;
            prev = node;
            node = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode();
        ListNode sec = new ListNode();
        ListNode thi = new ListNode();
        first.m_nValue = 1;
        sec.m_nValue = 2 ;
        thi.m_nValue = 3;
        first.m_pNext = sec;
        sec.m_pNext = thi;
        thi.m_pNext = null;
        ListNode test = ReverseList.reverse(first);
        while (test != null) {
            System.out.println(test.m_nValue + "");
            test = test.m_pNext;
        }
    }
}
