package offer;

/**
 * todo... 输入一个字符串，输出所有字符排列
 */
public class Permutation {
    static int index = 0;
    public static void main(String[] args) {
        String a = "abc123";
        permutationString(a.toCharArray());
    }

    private static void permutationString(char [] pStr) {
        if (pStr == null)
            return;
        permutationString(pStr, 0);
        System.out.println(index + "");
    }

    private static void permutationString(char[] pStr, int begin) {
        if (begin == pStr.length - 1) {
            index++;
            System.out.println(new String(pStr));
        } else {
            for (int i = begin; i<pStr.length; i++) {
                char temp = pStr[i];
                pStr[i] = pStr[begin];
                pStr[begin] = temp;
                permutationString(pStr,begin+1);
                temp = pStr[i];
                pStr[i] = pStr[begin];
                pStr[begin] = temp;
            }
        }
    }
}
