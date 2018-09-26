package offer;
//牛顿迭代法求平方根
public class SQRT {
    public static double sqrt(double c) {
        if (c < 0)
            throw new IllegalArgumentException("arguement should be larger than 0");
        double err = 1e-7;
        double x = c;
        while (Math.abs(x*x - c) > err) {
            x = (x + c/x)/2;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(SQRT.sqrt(5.0));
    }
}
