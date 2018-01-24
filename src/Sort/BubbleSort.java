package Sort;

import sun.security.util.Length;

public class BubbleSort {
    public static Integer [] array;
    public void sort(){
        int i,j;
        for(i = (array.length - 1);i>=0; i--){
            for(j=i-1; j>=0; j--){
                if(array[j] > array[i]){
                    int t = array[j];
                    array[j] = array[i];
                    array[i] = t;
                }
            }
        }
        for(i = 0; i < array.length; i++)
            System.out.print(array[i]);
    }

    public static void main(String[] args) {
        array = new Integer[]{5, 1, 3, 6, 8, 4, 6, 2};
        new BubbleSort().sort();
    }
}
