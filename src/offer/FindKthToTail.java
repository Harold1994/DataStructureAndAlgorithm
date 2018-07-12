package offer;
import offer.DeleteNodeInO1.ListNode;
public class FindKthToTail {
    public static ListNode fkt(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode ahead = head;
        ListNode behind = null;

        for (int i = 0; i<k; i++) {
            if (ahead.m_pNext != null)
                ahead = ahead.m_pNext;
            else
                return null;
        }
         behind = head;
        while (!(ahead.m_pNext == null)) {
            ahead = ahead.m_pNext;
            behind = behind.m_pNext;
        }
        return behind;

    }
}
