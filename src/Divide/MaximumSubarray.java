package Divide;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int [] array = new int[] {13,-3,-25,20,-3,-16,-23,18,20,-7,
                                    12,-5,-22,15,-4,7};
        int result = FindMaximumSubarray(array,0,array.length-1);
        System.out.println(result);
    }

    private static int FindMaximumSubarray(int[] array, int low, int high) {
        if(high == low)
            return  array[low];
        int leftsum,rightsum,crosssum,max;
        int mid = (high + low)/2;
        leftsum = FindMaximumSubarray(array,low,mid);
        rightsum = FindMaximumSubarray(array,mid+1,high);
        crosssum = FindMaxCrossingSubarray(array,low,mid,high);
        if(leftsum > rightsum && leftsum > crosssum)
            return leftsum;
        else if(rightsum > leftsum && rightsum > crosssum)
            return rightsum;
        else
            return crosssum;

    }

    private static int FindMaxCrossingSubarray(int[] array, int low, int mid, int high) {
        int leftSum = -12767;
        int sum = 0;
        for(int i = mid; i >= low; i--){
            sum = sum + array[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        int rightSum = -12767;
        sum = 0;
        for(int j = mid+1; j <= high; j++){
            sum += array[j];
            if(sum > rightSum)
                rightSum = sum;
        }

        return leftSum+rightSum;
    }
}
