package Sort;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int [] num = new int[] {41,45,33,485,15,8,41,0};
        insertSort(num);
        System.out.println(Arrays.toString(num));
    }

    private static void insertSort(int[] num) {
        int j,i;
        for(i = 1; i<num.length;i++){
            for(j=i;j>0;j--){
                if(num[j-1] > num[j]){
                    swap(num,j-1,j);
                }
            }
        }
    }

    private static void swap(int[] num, int i, int j) {
        int t;
        t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
