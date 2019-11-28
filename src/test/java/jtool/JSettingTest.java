package jtool;

import com.google.gson.JsonObject;

import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

class JSettingTest
{
    class Test
    {
        private String abd;

        public Test (String abd)
        {
            this.abd = abd;
        }

        @Override
        public String toString ()
        {
            return "Test{" +
                    "abd='" + abd + '\'' +
                    '}';
        }
    }

    @BeforeEach
    void setUp ()
    {
    }

    @org.junit.jupiter.api.Test
    void getObject ()
    {
        JSetting jSetting = new JSetting("a.json");
        jSetting.put("asdf", new Test("我爱你"));
        Test test = jSetting.getObject("asdf", Test.class);
        System.out.println(test.toString());

        jSetting.put("list", Collections.singletonList(new Test("列表测试")));
        List<Object> list = jSetting.getObjects("list");
        System.out.println(list.toString());

        jSetting.put("json",new JsonObject());

        jSetting.save();
    }
}


