package Sort;

import com.sun.scenario.effect.Merge;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer [] num = {0,5,8,9,3,4};
        System.out.println(Arrays.toString(num));
        sort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    private static void sort(Integer[] num, int low, int high) {
        int mid = (low + high)/2;
        if(low < high){
            sort(num,low,mid);
            sort(num,mid+1,high);
            merge(num,low,mid,high);
        }
    }

    private static void merge(Integer[] num, int low, int mid, int high) {
        Integer [] temp = new Integer[high - low +1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i<=mid && j<=high){
           temp[k++] = (num[i] < num[j]) ? num[i++] : num[j++];
        }

        while(i <= mid){
            temp[k++] = num[i++];
        }
        while(j <=high){
            temp[k++] = num[j++];
        }
        for(int k2 =0 ;k2<temp.length;k2++){
            num[low+k2] = temp[k2];
        }
    }
}
