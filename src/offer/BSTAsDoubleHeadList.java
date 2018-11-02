package offer;



public class BSTAsDoubleHeadList {
    static BSTNode last = null;
    public static void main(String[] args) {
        BSTNode head = new BSTNode(10);
        head.left = new BSTNode(6);
        head.left.left = new BSTNode(4);
        head.left.right = new BSTNode(8);
        head.right = new BSTNode(14);
        head.right.left = new BSTNode(12);
        head.right.right = new BSTNode(16);

        ConvertTree(head);
    }

    private static void ConvertTree(BSTNode head) {

        ConvertNode(head);
        while (last != null) {
            System.out.println(last.val + "");
            last = last.left;
        }
    }

    private static void ConvertNode(BSTNode node) {
        if (node == null)
            return;

        BSTNode cur = node;

        if (cur.left != null) {
            ConvertNode(cur.left);
        }

        cur.left = last;
        if (last != null)
            last.right = cur;

        last = cur;
        if (cur.right != null)
           ConvertNode(cur.right);
    }
}
