package jtool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 随机excel {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    static String goodses="6932720523498;大理牧场熟酸奶243g;5\n" +
            "99000184;今麦郎芒顿小镇柠檬水500ml;3\n" +
            "99000177;哈尔滨啤酒小麦王330ml;3\n" +
            "99000176;中沃体质能量牛磺酸580ml;4\n" +
            "99000175;江津江小白白酒100ml;20\n" +
            "99000172;康师傅鲜果橙500ml;3\n" +
            "99000171;康师傅酸枣露500ml;3\n" +
            "99000169;百事七喜柠檬味汽水550ml;3\n" +
            "99000168;可口可乐600ml;3.5\n" +
            "99000167;娃哈哈无汽苏打水350ml;3.5\n" +
            "99000166;脉动MI-PRO雪柚味运动饮料600ml;4.5\n" +
            "99000164;康师傅水晶葡萄310ml;2.5\n" +
            "99000163;美汁源花语系列420ml;5\n" +
            "99000162;百事美年达蜜桃味汽水600ml;3\n" +
            "99000161;伊利味可滋哈密瓜牛奶240ml;5.5\n" +
            "99000160;伊利味可滋木瓜牛奶240ml;5.5\n" +
            "99000159;伊利味可滋香蕉牛奶240ml;5.5\n" +
            "99000158;伊利谷粒多红谷牛奶250ml;3.5\n" +
            "99000157;伊利谷粒多黑谷牛奶250ml;3.5\n" +
            "99000156;美汁源果粒奶优原味450ml;4.5\n" +
            "99000155;水动乐营养素饮料橙味600ml;4.5\n" +
            "99000154;怡泉+C罐装330ml;4\n" +
            "99000140;脉动椰子菠萝味维生素饮料600ml;4.5\n" +
            "99000139;纯悦饮用水550ml;2\n" +
            "99000138;娃哈哈AD钙奶220ml;4\n" +
            "99000134;百事美年达葡萄汽水330ml;2.5\n" +
            "99000133;康美菊皇茶植物饮料310ml;3.5\n" +
            "99000131;猕猴桃果汁饮料240ml;3\n" +
            "99000129;蒙牛早餐奶核桃250ml;4\n" +
            "99000128;蒙牛早餐奶原麦250ml;4\n" +
            "99000122;新希望核桃花生奶250ml;2.5\n" +
            "99000121;新希望纯牛奶250ml;3\n" +
            "99000117;康师傅鲜橙汁450ml;3\n" +
            "99000116;康师傅香缤凤梨450ml;3\n" +
            "99000115;康师傅海晶柠檬500ml;3\n" +
            "99000113;康师傅山楂饮500ml;3\n" +
            "99000112;康师傅冰糖柠檬500ml;3\n" +
            "99000111;康师傅酸梅汤500ml;3\n" +
            "99000110;伊利安慕希希腊酸奶香草味205ml;4.5\n" +
            "99000108;伊利优酸乳乳饮料原味250ml;2\n" +
            "99000107;伊利金典纯牛奶250ml;5\n" +
            "99000106;伊利QQ星香草冰淇淋味牛奶125ml;2.5\n" +
            "99000103;雀巢咖啡香滑罐装180ml;28\n" +
            "99000101;达利园和其正600ml;4.5\n" +
            "99000100;达利园豆本豆(原味）360ml;5.5\n" +
            "99000099;达利园花生牛奶复合蛋白饮料500ml;4.5\n" +
            "99000098;达利园青梅绿茶500ml;3\n" +
            "99000096;乐虎氨基酸维生素功能饮料380ml;5";

    @Test
    void test() {
        String path = "/Users/wujieyuan/Downloads/交易记录表2020-03-09.xlsx";
        ExcelReader reader = ExcelUtil.getReader(path);
        List<Map<String, Object>> lines = reader.readAll();
        for (Map<String, Object> line : lines) {
            String mid = "170" + JRand.getRandomNumbers(6);
            line.put("机器编号", Long.valueOf(mid));
            line.put("货柜号", Long.valueOf(mid));
            String[] split = goodses.split("\n");
            String goods=split[JRand.getRandom(split.length)];
            String goodsNumber = goods.split(";")[0];
            String goodsName = goods.split(";")[1];
            line.put("商品编号", Long.valueOf(goodsNumber));
            line.put("商品名称", goodsName);
        }

        ExcelWriter writer = ExcelUtil.getWriter("/Users/wujieyuan/Downloads/交易记录表2020-03-09_1.xlsx");
        writer.write(lines, true);
        writer.close();

    }
}
