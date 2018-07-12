package offer;

import java.util.Random;

//有个输出0和1的BIASED RANDOM，它以概率p输出1，以概率1-p输出0，以此RANDOM函数为基础，生成另一个RANDOM函数，该函数以1/2的概率输出1，以1/2的概率输出0
//
//题目解答：
//
//两次调用该RANDOM函数，如果其概率为P(x)，调用2次
//
//P(1) = p       P(0) = 1-p
//
//P'(1) =p      P'(0) = 1-p
//
//概率如下：
//
//11  p*p        10  p*(1-p)
//
//01 (1-p)*p   00 (1-p)*(1-p)
public class GenerateEqualProbobalityNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int i = rand.nextInt(1);
        int j = rand.nextInt(1);
        if (i ==1 && j == 0)
            System.out.println(1);
        else if (i == 0 && j==1)
            System.out.println(0);
    }
}
