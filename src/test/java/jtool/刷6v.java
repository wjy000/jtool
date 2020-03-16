package jtool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;

public class 刷6v {
    @Test
    public void test() {

        for (int j = 0; j < 10; j++) {
            JExecutor.execute(() -> {
                HttpRequest request = HttpUtil.createGet("http://www.hao6v.com/e/enews/?enews=AddInfoPfen&classid=32&id=34569&doajax=1&ajaxarea=showpf&fen=1");
                for (int i = 0; i < 1000; i++) {
                    try {
                        request.cookie("");
                        HttpResponse response = request.execute();
                        System.out.println(Thread.currentThread().getName() + " " + response.body());
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        JThread.sleepForever();
    }
}
