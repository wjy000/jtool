package jtool;

import java.math.BigDecimal;

/**
 * 类型转换
 */
public class JConvert {
    public static double toDouble(Object num) {
        return new BigDecimal(String.valueOf(num)).doubleValue();
    }

    public static float toFloat(Object num) {
        return new BigDecimal(String.valueOf(num)).floatValue();
    }

    public static int toInt(Object num) {
        return new BigDecimal(String.valueOf(num)).intValue();
    }

    public static long toLong(Object num) {
        return new BigDecimal(String.valueOf(num)).longValue();
    }
}
