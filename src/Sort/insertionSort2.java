package Sort;

import javax.xml.stream.events.EndDocument;
import java.util.Arrays;

public class insertionSort2 {
    public static void main(String[] args) {
        int[] num = new int[] {1,5,5,9,28,9,4,3,1};
        //insertSort2(num);
        //insertSort3(num);
        new SelectionSort(num);
        System.out.println(Arrays.toString(num));
    }

    private static void insertSort3(int[] num) {
        int i,k,j,temp;
        for(i = 1; i<num.length;i++){
            temp = num[i];
            if(num[i-1] <= temp){
                k = i;
            }else{
                k = binarySearch(num,0,i-1,temp);
                for(j = i;j>k;j--){
                    num[j] = num[j-1];
                }
            }
            num[k] = temp;
        }
    }

    private static int binarySearch(int[] num, int start, int end, int temp) {
        int mid;
        while (start <= end){
            mid = (int) Math.floor((start + end)/2);
            if(num[mid] < temp){
                if(temp <= num[mid + 1]){
                    return mid+1;
                }else {
                    start = mid+1;
                }
            }
            else {
                if(end == 0){
                    return 0;
                }else {
                    end = mid;
                }
            }
        }
        return 0;
    }

    private static void insertSort2(int[] num) {
        int i,j,t;
        for(i = 1; i< num.length; i++){
            t = num[i];
            for(j = i; j>0; j--){
                if(num[j-1] > t){
                    num[j] = num[j-1];
                }else{
                    num[j] = t;
                    break;
                }
            }
        }
    }
}
