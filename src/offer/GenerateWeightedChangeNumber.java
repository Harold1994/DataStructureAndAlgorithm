package offer;

import java.util.Random;

/*
题目：给定一个数组，每个值都是一个权值。随机返回数组中的数，要求权值高的相应的返回的概率高。比如现在数组存储了音乐的打分，要求随机返回数组中一个数的值。（假设数组中的值都是整数）
思路： 以 A:3， B:5， C:2，D:1 四条记录上随机选取一个值输出为例，（是否以权重排序这个无所谓）
对于
A 3
B 5
C 2
D 1
首先，将第n行的数值赋为第n行加第n-1行的，递归执行，如下：
A 3
B 8
C 10
D 11
可以看出，数组变换后，当产生[1,3]的随机数时，对应输出3，当产生[4，8]的随机数时，对应输出5，当产生[9,10]的随机数时，对应输出2，当产生11时，对应输出1。


 */
public class GenerateWeightedChangeNumber {
    public static void main(String[] args) {
        int [] nums = new int [] {3,5,2,1};
        int n = 0;
        int iter = 20;
        int [] num_copy = nums.clone();
        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 1; i<nums.length; i++) {
            nums[i]=nums[i]+nums[i-1];
        }

        Random rand = new Random();
        for (int i = 0; i<iter; i++) {
            n = rand.nextInt(sum) + 1;
            int pos = getRandom(nums, 0, nums.length-1, n);
            System.out.println(n + " " + num_copy[pos]);
        }
    }

    private static int getRandom(int[] nums, int begin, int end, int n) {
        if (begin >= end)
            return begin;
        int mid = (end + begin)/2;
        if (n >  nums[mid]) {
            return getRandom(nums, mid+1, end,n);
        }
        else
            return getRandom(nums, begin, mid, n);//注意mid
    }
}
