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
        long price_fen = (long) (JString.toFloat(4.7+"") * 100);
        System.out.println(price_fen);
    }
}