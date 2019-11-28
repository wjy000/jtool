package jtool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JDesTest
{

    @BeforeEach
    void setUp ()
    {
    }

    @AfterEach
    void tearDown ()
    {
    }

    @Test
    void encrypt () throws Exception
    {
        String encrypt = JDes.encrypt("abc", "asdfaweg");
        System.out.println(encrypt);
    }

    @Test
    void decrypt () throws Exception
    {
        String encrypt = JDes.decrypt("K+z1gEkyghI=", "asdfaweg");
        System.out.println(encrypt);
    }
}