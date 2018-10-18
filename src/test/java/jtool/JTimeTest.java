package jtool;

import jtool.entity.TransTime;

import static org.junit.jupiter.api.Assertions.*;

class JTimeTest
{

    @org.junit.jupiter.api.BeforeEach
    void setUp ()
    {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown ()
    {
    }

    @org.junit.jupiter.api.Test
    void transTime ()
    {
        TransTime transTime = JTime.transTime(28234729);
        System.out.println(transTime.toString());
    }
}