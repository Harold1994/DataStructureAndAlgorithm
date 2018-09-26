package Sort;

import java.util.Arrays;

public class insort {
    public static void main(String[] args) {
        int [] num = new int[]{4,5,89,2,3,8,9,2,15};
        //new SelectionSort(num);
//        new ShellSort(num);
        new QuickSort(num);
        System.out.println(Arrays.toString(num));
    }
    public static void swap(int[] num, int i, int j) {
        int t;
        t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
