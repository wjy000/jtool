package jtool.entity;

public class TransTime
{
    public long days;
    public long hours;
    public long minutes;
    public long seconds;

    public TransTime ()
    {
    }

    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder();
        if (days != 0)
            builder.append(days + "天");
        if (hours != 0)
            builder.append(hours + "时");
        if (minutes != 0)
            builder.append(minutes + "分");
        if (seconds != 0)
            builder.append(seconds + "秒");
        String s = builder.toString();
        if(s.startsWith("-")){
            s = s.replace("-", "");
            s="-"+s;
        }
        return s;
    }
}