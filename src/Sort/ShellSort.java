package Sort;

import java.util.Arrays;

public class ShellSort {
    public ShellSort(int[] num) {
        int n = num.length;
        int i,j,gap = 1;
        while(gap <  n/3)
            gap = gap*3 + 1;
        for(;gap>0;gap/=3){
           for(i = gap; i<n; i++){
                  int t =num[i];
                  for(j=i-gap;j>=0&&num[j]>t;j=j-gap){
                      num[j+gap] = num[j];
                  }
                  num[j+gap] = t;
           }
        }
    }
}
