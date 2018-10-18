package jtool;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class JThrow
{
    /**
     * 异常堆栈转化为文本
     *
     * @param throwable
     * @return
     */
    public static String toString (Throwable throwable)
    {
        StringWriter sw = null;
        PrintWriter printWriter = null;
        try
        {
            if (throwable != null)
            {
                sw = new StringWriter();
                printWriter = new PrintWriter(sw);
                throwable.printStackTrace(printWriter);
                printWriter.flush();
                sw.flush();
                return sw.toString();
            } else
                return null;
        } finally
        {

            try
            {
                if (sw != null)
                    sw.close();
                if (printWriter != null)
                    printWriter.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
