package jtool.jfinal;


import com.jfinal.core.Controller;

public class JFinaltool
{
    //获取客户端ip
    public static String getClientIP (Controller controller)
    {
        String ip = controller.getRequest().getHeader("x-forwarded-for");
        if (ip != null && !ip.isEmpty())
        {
            ip = ip.split(",")[0];//如果使用了负载均衡的话,会有多个ip,第一个是客户的真实ip
        }
        if (ip == null || ip.isEmpty())
            ip = controller.getRequest().getRemoteAddr();
        return ip;
    }
}
