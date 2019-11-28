package jtool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/3/20.
 */
public class JExecutor
{
    private static final ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    private static final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

    /**
     * 自动管理的线程池
     * @param runnable
     */
    public static void execute (Runnable runnable)
    {
        newCachedThreadPool.execute(runnable);
    }

    /**
     * 单线程
     * @param runnable
     */
    public static void executeSingle (Runnable runnable)
    {
        newSingleThreadExecutor.execute(runnable);
    }

    /**
     * 单线程
     * @param runnables
     */
    public static void executeSingle (Runnable... runnables)
    {
        for (Runnable runnable : runnables)
        {
            newSingleThreadExecutor.execute(runnable);
        }
    }

    /**
     * 单线程
     * @param runnables
     */
    public static void executeSingle (List<Runnable> runnables)
    {
        for (Runnable runnable : runnables)
        {
            newSingleThreadExecutor.execute(runnable);
        }
    }

    public static ExecutorService getNewCachedThreadPool ()
    {
        return newCachedThreadPool;
    }

    public static ExecutorService getNewSingleThreadExecutor ()
    {
        return newSingleThreadExecutor;
    }
}


