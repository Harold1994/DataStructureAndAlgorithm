package offer;

/**
 * todo: 复制复杂链表
 */
class ComplexListNode {
    int val;
    ComplexListNode next;
    ComplexListNode Sibling; //指向随机结点

    public ComplexListNode(int val) {
        this.val = val;
    }
}

public class CopyOfComplexList {


    public static void main(String[] args) {
        ComplexListNode one = new ComplexListNode(1);
        ComplexListNode two = new ComplexListNode(2);
        ComplexListNode thr = new ComplexListNode(3);
        ComplexListNode fou = new ComplexListNode(4);
        ComplexListNode fiv = new ComplexListNode(5);
        one.next = two;
        one.Sibling = thr;
        two.next = thr;
        two.Sibling = fiv;
        thr.next = fou;
        thr.Sibling = null;
        fou.next = fiv;
        fou.Sibling = two;
        fiv.next = null;
        fiv.Sibling = null;

        ComplexListNode ans = CopyList(one);
        while (ans != null) {
            System.out.println(" val " + ans.val);
            if (ans.Sibling != null)
                System.out.println(ans.Sibling.val);
            ans = ans.next;
        }
    }

    private static ComplexListNode CopyList(ComplexListNode one) {
        CloneNodes(one);
        ConnectSiblingNode(one);
        return ReconnectNodes(one);
    }

    private static ComplexListNode ReconnectNodes(ComplexListNode one) {
        ComplexListNode node = one;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;
        if (node != null) {
            clonedHead = node.next;
            clonedNode = node.next;
            node.next = clonedHead.next;
            node = node.next;
        }

        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }

    private static void ConnectSiblingNode(ComplexListNode one) {
        ComplexListNode node = one;
        while (node != null) {
            ComplexListNode cloned = node.next;
            if (node.Sibling != null) {
                cloned.Sibling = node.Sibling.next;
            }
            node = cloned.next;
        }
    }

    private static void CloneNodes(ComplexListNode one) {
        ComplexListNode node = one;
        while (node != null) {
            ComplexListNode cloned = new ComplexListNode(node.val);
            cloned.next = node.next;
            cloned.Sibling = null;

            node.next = cloned;
            node = cloned.next;
        }
    }
}
