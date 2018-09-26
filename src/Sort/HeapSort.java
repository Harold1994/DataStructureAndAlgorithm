package Sort;

import java.util.Arrays;

public class HeapSort {

        private int[] array;

        public HeapSort(int arr[]) {
            this.array = arr;
        }

        private int getParentIndex(int child) {
            return (child - 1) / 2;
        }

        private int getLeftChildIndex(int parent) {
            return 2 * parent + 1;
        }

        private void initHeap() {
            int last = array.length - 1;
            for (int i = getParentIndex(last);i>=0;--i){
                int k = i;
                int j = getLeftChildIndex(k);
                while(j <= last){
                    if(j<last){
                        if(array[j] <= array[j+1])
                            j++;
                    }
                    if(array[k] > array[j])
                        break;
                    else{
                        swap(k,j);
                        k=j;
                    }
                    j=getLeftChildIndex(k);
                }
            }
        }
    public void sort() {
        initHeap();
        int last = array.length - 1;
        while (last > 0) {
            swap(0, last);
            last--;
            if (last > 0) { // 这里如果不判断，将造成最终前两个元素逆序。
                adjustHeap(last);
            }
        }
    }

    private void adjustHeap(int lastIndex) {
        int k = 0;
        while (k <= getParentIndex(lastIndex)) {
            int j = getLeftChildIndex(k);
            if (j < lastIndex) {
                if (array[j] < array[j + 1])
                    j++;
            }
            if (array[k] < array[j]) {
                swap(k, j);
                k = j;
            } else
                break;
        }
    }

    private void swap(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,1,4,78,23,45,12,16,48,49,14,63,2,45,4};
        HeapSort hs = new HeapSort(arr);
        hs.sort();
        System.out.println(Arrays.toString(hs.array));
        }
    }
