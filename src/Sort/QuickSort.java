package Sort;

import sun.misc.LRUCache;

import java.util.Arrays;
import java.util.Random;

import static Sort.insort.swap;

public class QuickSort {
    public QuickSort(int[] num) {
        if(num == null)
            return;
        qsort(num,0,num.length - 1);
    }

//    private void qsort(int[] num, int start, int end) {
//        if(start >= end)
//            return;
//        int mid = num[end];
//        int left=start;
//        int right = end - 1;
//        while(left < right){
//            while (num[left] <=mid && left < right){
//                left++;
//            }
//            while(num[right] >= mid && right>left){
//                right--;
//            }
//
//            swap(num, left,right);
//        }
//
//          if(num[left] >= num[end])
//              swap(num,left,end);
//        else
//            left++;
//        qsort(num,start,left-1);
//        qsort(num,left+1,end);
//    }

    private static void qsort(int[] A,int p,int r){
        if(p<r){
            int q = partition(A,p,r);
            qsort(A,p,q-1);
            qsort(A,q+1,r);
        }
        return;
    }
    private static void rand_qsort(int[] A,int p,int r){
        if(p<r){
            int q = randomized_Partition(A,p,r);
            qsort(A,p,q-1);
            qsort(A,q+1,r);
        }
        return;
    }

    private static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for(int j = p; j<=r-1;j++){
            if(A[j] < x){
                i++;
                swap(A,j,i);
            }
        }
        swap(A,r,i+1);
        return i+1;
    }

    public static int randomized_Partition(int[] A, int p, int r){
        Random rand = new Random();
        int randNum = rand.nextInt(r-p+1) + p;
        swap(A,r,randNum);
        return partition(A,p,r);
    }

    public static void main(String[] args) {
        int [] nums = new int[]{25,12,0,45,152,65,78,15346,10,4,14};
        QuickSort.rand_qsort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));


    }
}
