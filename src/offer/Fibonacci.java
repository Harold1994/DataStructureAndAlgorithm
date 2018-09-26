package offer;

import java.math.BigInteger;
import java.sql.Time;

public class Fibonacci {
    public static BigInteger getFibRecursive(int n) {
        if (n <= 0)
            return BigInteger.ZERO;
        if (n == 1)
            return BigInteger.valueOf(1);

        return getFibRecursive(n-1).add(getFibRecursive(n-2));

    }

    public static long getFibIter(int n) {
        int result[] = new int[] {0,1};
        if (n < 2)
            return result[n];
        long  fibNMinuxOne = 1;
        long fibNMinuxTwo = 0;
        long fibN = 0;
        for (int i = 2; i<=n; i++){
            fibN = fibNMinuxOne + fibNMinuxTwo;
            fibNMinuxTwo = fibNMinuxOne;
            fibNMinuxOne = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        BigInteger a = BigInteger.ZERO;
        long begin = System.nanoTime();
        a =  getFibRecursive(15);
        long end = System.nanoTime();
        System.out.println(end - begin);

        long b = 0l;
        begin = System.nanoTime();
        b =  getFibIter(15);
        end = System.nanoTime();
        System.out.println(end - begin);
    }
}
