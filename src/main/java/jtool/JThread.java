package jtool;

/**
 * Created by Administrator on 2016/10/2 0002.
 */
public class JThread
{
    public static void sleep (long time)
    {
        if (time == 0)
            return;
        try
        {
            Thread.sleep(time);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void sleepForever ()
    {
        try
        {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException iex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
