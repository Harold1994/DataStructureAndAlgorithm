package offer;
//给定中序遍历和先序遍历，构造树
public class RebuildTree {
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
        public BinaryTreeNode(int data) {
            this.data = data;
        }

        public BinaryTreeNode() {
        }
    }

    public BinaryTreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return constructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private BinaryTreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int root = pre[startPre];
        int locateRoot = locate(root, in, startIn, endIn);
        if (locateRoot == -1)
            return null;
        BinaryTreeNode treeRoot = new BinaryTreeNode(root);
        treeRoot.left = constructCore(pre, startPre+1,startPre + locateRoot - startIn, in,startIn,locateRoot-1);
        treeRoot.right = constructCore(pre, startPre + locateRoot-startIn + 1, endPre, in, locateRoot + 1, endIn);
        return treeRoot;
    }

    private int locate(int root,int[] in, int startIn, int endIn) {
        for (int i = startIn; i<endIn; i++) {
            if (root == in[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = new int [] {10,6,4,8,14,12,16};
        int[] in = new int [] {4,6,8,10,12,14,16};
        RebuildTree rb = new RebuildTree();
        BinaryTreeNode bn = rb.construct(pre,in);
        System.out.println(bn.right.data + "");
    }
}