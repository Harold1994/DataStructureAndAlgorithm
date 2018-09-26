package offer;

public class DeleteNodeInO1 {
    public static class ListNode {
        int m_nValue;
        ListNode m_pNext;

        public ListNode() {
        }
    }
    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.m_pNext != null) {
            ListNode next = toBeDeleted.m_pNext;
            toBeDeleted.m_nValue = next.m_nValue;
            toBeDeleted.m_pNext = next.m_pNext;
            next = null;
        } else if (head == toBeDeleted) {
            toBeDeleted = null;
            head = null;
        }
        else {
            ListNode node = head;
            while (node.m_pNext != toBeDeleted)
                node = node.m_pNext;
            node.m_pNext = null;
            toBeDeleted = null;
        }
    }
}
