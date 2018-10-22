package offer;

import java.util.Arrays;

/**
 * todo: 判断一个序列是不是搜索二叉树的后序遍历
 */
public class VerifySequenceOfBST {
    public static void main(String[] args) {
        int [] seq = new int [] {3,10,18,17,21,19,15};
        System.out.println(verify(seq,seq.length));
    }

    private static boolean verify(int[] seq, int length) {
        if (seq == null || length <= 0)
            return false;

        int root = seq[length - 1];
        int i = 0;
        for (; i<length-1;i++) {
            if (seq[i]>root)
                break;;
        }

        int j = i;
        for (; j<length-1; j++)
            if (seq[j] < root)
                return false;
        boolean left = true;
        if (i>0)
            left = verify(seq, i);
        boolean right = true;
        if (i<length - 1)
            right = verify(Arrays.copyOfRange(seq,i,length),length - i - 1);
        return left&&right;
    }
}
