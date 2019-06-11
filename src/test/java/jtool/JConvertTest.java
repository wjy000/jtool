package jtool;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class JConvertTest {

    @Test
    void toDouble() {
        float a=1.51f;
        double b= Double.valueOf(a);
        double c=a;
        double d=JConvert.toDouble(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    @Test
    void toFloat() {
        System.out.println(JConvert.toFloat(1.51d));
    }

    @Test
    void toInt() {
        System.out.println(JConvert.toInt(1.51f));
    }

    @Test
    void toLong() {
        System.out.println(JConvert.toLong(1.51f));
    }
}