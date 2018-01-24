package DataStructor;

public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot;

    class BSTNode<T extends Comparable<T>> {
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;
        T key;

        public BSTNode(T val) {
            this.key = val;
        }

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        public T getKey() {
            return key;
        }

        public String toString() {
            return "key:"+key;
        }
    }

    public void preorder_tree_walk(BSTNode<T> node) {
        if (node == null)
            return;
        System.out.println(node.key);
        preorder_tree_walk(node.left);
        preorder_tree_walk(node.right);
    }

    public void preorder_tree_walk() {
        preorder_tree_walk(mRoot);
    }

    public void inorder_tree_walk(BSTNode<T> node) {
        if (node == null)
            return;
        inorder_tree_walk(node.left);
        System.out.println(node.key);
        inorder_tree_walk(node.right);
    }

    public void inorder_tree_walk() {
        inorder_tree_walk(mRoot);
    }

    public void posorder_tree_walk(BSTNode<T> node) {
        if (node == null)
            return;
        posorder_tree_walk(node.left);
        posorder_tree_walk(node.right);
        System.out.println(node.key);
    }

    public void posorder_tree_walk() {
        posorder_tree_walk(mRoot);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    public BSTNode<T> getPreSuccessor(BSTNode<T> node) {
        if (node.left != null)
            return maximum(node.left);
        BSTNode<T> y = node.parent;
        while (y != null && node == y.left) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    public BSTNode<T> getSuccessor(BSTNode<T> node) {
        if (node.right != null)
            return minimum(node.right);
        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = node.parent;
        while (y != null && node == y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    public void insert(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;
        while (x != null) {
            y = x;
            if (z.key.compareTo(x.key) < 0)
                x = x.left;
            else x = x.right;
        }
        z.parent = y;
        if (y == null)
            bst.mRoot = z;
        else {
            int cmp = z.key.compareTo(y.key);
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    public void insert(T key) {
        BSTNode<T> z = new BSTNode<T>(key, null, null, null);

        // 如果新建结点失败，则返回。
        if (z != null)
            insert(this, z);
    }

    private void transplant(BSTree<T> bst, BSTNode<T> u, BSTNode<T> v) {
        if (u.parent == null)
            bst.mRoot = v;
        else if (u == u.parent.left)
            u.parent.left = v;
        else u.parent.right = v;
        if (v != null)
            v.parent = u.parent;
    }

    public BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> y = null;
        if (z.left == null)
            transplant(bst, z, z.right);
        else if (z.right == null)
            transplant(bst, z, z.left);
        else {
            y = minimum(z.right);
            if (y.parent != z) {
                transplant(bst, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(bst, z, y);
            y.left = z.left;
            y.left.parent = y;
        }
        return y;
    }
    private void print(BSTNode<T> tree, T key, int direction) {

        if(tree != null) {

            if(direction==0)    // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
    private void destroy(BSTNode<T> tree) {
        if (tree==null)
            return ;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree=null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<Integer>();
        bst.insert(1);
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(6);
        bst.inorder_tree_walk();
    }
}
