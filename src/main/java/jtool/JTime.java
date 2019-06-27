package jtool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jtool.entity.TransTime;


/**
 * Created by Administrator on 2016/4/12 0012.
 */
public class JTime
{
    public static final String FORMAT_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String FORMAT_DAY = "yyyy-MM-dd";
    private static final SimpleDateFormat SI_FORMAT_SS = new SimpleDateFormat(FORMAT_SS);

    /**
     * 将时间转化成天时分秒
     *
     * @param time
     * @return
     */
    public static TransTime transTime (long time)
    {
        TransTime transTime = new TransTime();
        long days = time / (1000 * 60 * 60 * 24);
        long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (time % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (time % (1000 * 60)) / 1000;
        transTime.days = days;
        transTime.hours = hours;
        transTime.minutes = minutes;
        transTime.seconds = seconds;
        return transTime;
    }

    /**
     * 获取今天
     *
     * @return
     */
    public static int getToday ()
    {
        Calendar calendar = Calendar.getInstance();
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        return DAY_OF_MONTH;
    }

    public static int getMonth ()
    {
        Calendar calendar = Calendar.getInstance();
        // 显示月份 (从0开始, 实际显示要加一)
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public static int getYear ()
    {
        Calendar calendar = Calendar.getInstance();
        // 显示年份
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 时间文本转换成时间戳
     *
     * @param pattern "yyyy-MM-dd hh:mm:ss"
     * @param source  "2016-07-08 19:00:00"
     * @return
     */
    public static long getTime (String pattern, String source)
    {
        try
        {
            return new SimpleDateFormat(pattern).parse(source).getTime();
        } catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getTime (long timeInMillis, SimpleDateFormat dateFormat)
    {
        return dateFormat.format(new Date(timeInMillis));
    }

    public static String getTime (long timeInMillis)
    {
        return getTime(timeInMillis, SI_FORMAT_SS);
    }

    public static long getCurrentTimeInLong ()
    {
        return System.currentTimeMillis();
    }

    public static String getCurrentTimeInString ()
    {
        return getTime(getCurrentTimeInLong());
    }

    public static String getCurrentTimeInString (SimpleDateFormat dateFormat)
    {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    public static String getYesterday ()
    {
        return getTime(-1, FORMAT_DAY);
    }

    /**
     * 获取指定的日期,比如昨天 addDay=-1  明天 addDay=1
     *
     * @param addDay
     * @param format
     * @return
     */
    public static String getTime (int addDay, String format)
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, addDay);
        Date time = cal.getTime();
        return new SimpleDateFormat(format).format(time);
    }
}
