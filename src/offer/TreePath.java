package offer;

import DataStructor.LinkedStack;
import DataStructor.Stack;
import sun.jvm.hotspot.debugger.linux.arm.LinuxARMThreadContext;

import java.util.ArrayList;
import java.util.List;

/**
 * todo：二叉树中和为某一值的路径
 */
 class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode() {
    }
}

public class TreePath {


    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        node.left = new BinaryTreeNode(5);
        node.left.left = new BinaryTreeNode(4);
        node.left.right = new BinaryTreeNode(7);
        node.right = new BinaryTreeNode(12);

        findPath(node, 22);
    }


    private static void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null)
            return;
        List<Integer> list = new ArrayList<>();
        int curSum = 0;
        PreOrder(root, expectedSum, list, curSum);
    }

    private static void PreOrder(BinaryTreeNode root, int expectedSum, List<Integer> list, int curSum) {
        list.add(root.val);
        curSum += root.val;

        if (root.left == null && root.right == null) {
            if (curSum == expectedSum) {
                for (int i : list)
                    System.out.print(i + " --> ");
            }
            System.out.println();
        }

        if (root.left != null)
            PreOrder(root.left, expectedSum, list, curSum);
        if (root.right != null)
            PreOrder(root.right, expectedSum, list, curSum);

        list.remove(list.size() - 1);
        curSum -= root.val;
    }
}
