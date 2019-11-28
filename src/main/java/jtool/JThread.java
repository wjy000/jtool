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

    /**
     * 等待线程结束. 调用 {@link Thread#join()} 并忽略 {@link InterruptedException}
     *
     * @param thread 线程
     */
    public static void waitForDie(Thread thread) {
        boolean dead = false;
        do {
            try {
                thread.join();
                dead = true;
            } catch (InterruptedException e) {
                // ignore
            }
        } while (!dead);
    }
    /**
     * 获取JVM中与当前线程同组的所有线程<br>
     *
     * @return 线程对象数组
     */
    public static Thread[] getThreads() {
        return getThreads(Thread.currentThread().getThreadGroup().getParent());
    }

    /**
     * 获取JVM中与当前线程同组的所有线程<br>
     * 使用数组二次拷贝方式，防止在线程列表获取过程中线程终止<br>
     * from Voovan
     *
     * @param group 线程组
     * @return 线程对象数组
     */
    public static Thread[] getThreads(ThreadGroup group) {
        final Thread[] slackList = new Thread[group.activeCount() * 2];
        final int actualSize = group.enumerate(slackList);
        final Thread[] result = new Thread[actualSize];
        System.arraycopy(slackList, 0, result, 0, actualSize);
        return result;
    }

    /**
     * 获取进程的主线程<br>
     * from Voovan
     *
     * @return 进程的主线程
     */
    public static Thread getMainThread() {
        for (Thread thread : getThreads()) {
            if (thread.getId() == 1) {
                return thread;
            }
        }
        return null;
    }
}
