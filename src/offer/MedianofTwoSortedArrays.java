package offer;
//两个排序数组寻找中位数
public class MedianofTwoSortedArrays {
    public static double getMedian(int[] a, int [] b) {
        int len1 = a.length;
        int len2 = b.length;
        System.out.println(len1 + " " + len2);
        if (len1 == 0) {
            if (len2 % 2 == 1)
                return b[len2/2];
            else
                return (b[len2/2 - 1] + b[len2/2])/2d;
        }

        if (len2 == 0) {
            if (len1 % 2 == 1)
                return a[len1/2];
            else
                return (a[len1/2 - 1] + a[len1/2])/2d;
        }

        int position = (len1 + len2)/2 + 1;
        int last = 0;
        int second_last = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < position && j < len1 && k < len2) {
            if (a[j] <= b[k]) {
                second_last = last;
                last = a[j++];
            }
            else {
                second_last = last;
                last = b[k++];
            }
            i++;
        }

        while (i < position && j < len1) {
           second_last = last;
           last = a[j++];
           i++;
        }
        while (i < position && k < len2) {
            second_last = last;
            last = b[k++];
            i++;
        }

        if ((len1 + len2) % 2 == 1)
            return last;
        else
            return (last + second_last)/2d;
    }

    public static void main(String[] args) {
        int [] a = new int [] {1};
        int [] b = new int [] {2,3,4};
        System.out.println(getMedian(a,b));
    }
}
