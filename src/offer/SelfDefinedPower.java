package offer;

import java.util.Map;

public class SelfDefinedPower {
    public static double Power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new IllegalArgumentException("zero cant be divided");
        }
        int  absExp = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, absExp);
        if (exponent < 0)
            return result = 1.0/result;
        else
            return result;
    }

    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result = result * base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SelfDefinedPower.Power(0,-1));
    }
}
