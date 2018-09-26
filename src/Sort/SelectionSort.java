package Sort;

import static Sort.insort.swap;

public class SelectionSort {

    public SelectionSort(int[] num) {
        int n = num.length;
        int min,j;
        for(int i = 0; i < n; i++){
            min = i;
            for(j = i + 1; j < n; j++){
                if(num[j] < num[min]){
                    min = j;
                }
            }
           swap(num,i,min);
        }
    }
}
