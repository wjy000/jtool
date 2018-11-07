package jtool;

import java.math.BigInteger;

public class JMath
{
    /**
     * a-b
     *
     * @param a
     * @param b
     * @return
     */
    public static BigInteger BigIntegerSub (long a, long b)
    {
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
    public static BigInteger BigIntegerAdd (long a, long b)
    {
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
    public static BigInteger BigIntegerMultiply (long a, long b)
    {
        BigInteger big_a = BigInteger.valueOf(a);
        BigInteger big_b = BigInteger.valueOf(b);
        return big_a.multiply(big_b);
    }

}
