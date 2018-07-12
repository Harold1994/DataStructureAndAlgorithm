package offer;

public class RepeatNum {
    //判断数组是否有重复数字
    public static boolean dumplicated(int numbers[], int length) {
        if (numbers == null || length == 0)
            return false;
        for (int i = 0; i<length; i++) {
            if (numbers[i] < 0 || numbers[i] > length -1) {
                return false;
            }
        }

        for (int i = 0; i<length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    System.out.println(numbers[i]);
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
    //不修改数组找出重复数字
    public static int getDuplication(int [] numbers, int length) {
        if (numbers == null || length == 0)
            return -1;
        int start = 1;
        int end = length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, mid);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (mid-start +1)) {
                end = mid;
            }
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers == null)
            return 0;
        int count = 0;
        for (int i = 0; i<length; i++) {
            if (numbers[i] >= start && numbers[i] <=end)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] aa = new int[]{3,2,2,3,1};
        System.out.println(getDuplication(aa,5));
    }
}
