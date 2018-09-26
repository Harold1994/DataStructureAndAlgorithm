package offer;

import java.util.Arrays;

public class QuickSort {
    public static void QS(int [] arr) {
        if (arr ==  null)
            return ;
        int length = arr.length;
        qsort(arr, 0, length-1);
    }

    private static void qsort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);
            qsort(arr, start,mid-1);
            qsort(arr, mid+1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int i = start-1;
        for (int j = start; j<end; j++) {
            if (arr[j] < x) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[end];
        arr[end] = arr[i+1];
        arr[i+1] = tmp;
    return i + 1;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{25,12,0,45,152,65,78,15346,10,4,14};
        QuickSort.QS(nums);
        System.out.println(Arrays.toString(nums));
    }
}
