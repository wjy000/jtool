package jtool;

import jtool.entity.TransTime;

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
        TransTime transTime = JTime.transTime(776710694);
        TransTime transTime1 = JTime.transTime(-776710694);
        System.out.println(transTime.toString());
        System.out.println(transTime1.toString());
    }
}