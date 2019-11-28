package jtool;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class JThrow {
    /**
     * 异常堆栈转化为文本
     *
     * @param throwable
     * @return
     */
    public static String toString(Throwable throwable) {
        StringWriter sw = null;
        PrintWriter printWriter = null;
        try {
            if (throwable != null) {
                sw = new StringWriter();
                printWriter = new PrintWriter(sw);
                throwable.printStackTrace(printWriter);
                printWriter.flush();
                sw.flush();
                return sw.toString();
            } else
                return null;
        } finally {

            try {
                if (sw != null)
                    sw.close();
                if (printWriter != null)
                    printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获得完整消息，包括异常名
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        if (null == e) {
            return "null";
        }
        return JString.format("{}: {}", e.getClass().getSimpleName(), e.getMessage());
    }

    /**
     * 获得消息，调用异常类的getMessage方法
     *
     * @param e 异常
     * @return 消息
     */
    public static String getSimpleMessage(Throwable e) {
        return (null == e) ? "null" : e.getMessage();
    }
}
