package jtool;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class JMath {
    /**
     * a-b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigInteger BigIntegerSub(long a, long b) {
        BigInteger big_a = BigInteger.valueOf(a);
        BigInteger big_b = BigInteger.valueOf(b);
        return big_a.subtract(big_b);
    }

    /**
     * a+b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigInteger BigIntegerAdd(long a, long b) {
        BigInteger big_a = BigInteger.valueOf(a);
        BigInteger big_b = BigInteger.valueOf(b);
        return big_a.add(big_b);
    }

    /**
     * a*b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigInteger BigIntegerMultiply(long a, long b) {
        BigInteger big_a = BigInteger.valueOf(a);
        BigInteger big_b = BigInteger.valueOf(b);
        return big_a.multiply(big_b);
    }

    /**
     * 保留x位小数
     *
     * @param num   数字
     * @param scale 小数位数
     * @param mode  向上还是向下取值，是否四舍五入等等
     * @return
     */
    public static BigDecimal decimalScale(double num, int scale, RoundingMode mode) {
        BigDecimal bigDecimal = new BigDecimal(num).setScale(scale, mode);
        return bigDecimal;
    }


    /**
     * @see JMath#decimalScale(double, int, RoundingMode)
     */
    public static BigDecimal decimalScale(String num, int scale, RoundingMode mode) {
        return decimalScale(Double.valueOf(num), scale, mode);
    }

}
