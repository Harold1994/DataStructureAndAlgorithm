package offer;

import sun.security.krb5.internal.crypto.Des;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SerializeTree {
    public static void Serialize(BinaryTreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("$");
            return ;
        }

        sb.append(node.val);
        Serialize(node.left, sb);
        Serialize(node.right, sb);
    }

    public static BinaryTreeNode Deserialize(StringBuilder sb) throws IOException {
        if(sb.length()==0)
            return null;
        String num = sb.substring(0,1);
        sb.deleteCharAt(0);
        if (num.equals("$"))
            return null;
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(num));
        node.left = Deserialize(sb);
        node.right = Deserialize(sb);
        return node;
    }

    public static void main(String[] args) throws IOException {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);
        StringBuilder sb = new StringBuilder();
        Serialize(root,sb);
        System.out.println(sb.toString());

        BinaryTreeNode ans = Deserialize(sb);
        System.out.println(ans.right.left.val);
    }
}
