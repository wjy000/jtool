package jtool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class JMathTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bigIntegerSub() {
    }

    @Test
    void bigIntegerAdd() {
    }

    @Test
    void bigIntegerMultiply() {
    }

    @Test
    void decimalScale() {
        System.out.println(JMath.decimalScale(0.01,2, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.7 + "", 1, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.7, 1, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.7, 0, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.123, 1, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.123, 2, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.123, 3, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.883, 1, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.883, 2, RoundingMode.UP).doubleValue());
        System.out.println(JMath.decimalScale(4.883, 3, RoundingMode.UP).doubleValue());
    }
}