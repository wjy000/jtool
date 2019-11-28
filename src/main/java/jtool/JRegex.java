package jtool;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/15.
 */
public class JRegex
{
    //是否包含
    public static boolean contain (String source, String pattern)
    {
        Pattern regex = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(source);
        return regexMatcher.find();
    }

    public static String matcherOne (String source, String pattern)
    {
        return matcherOne(source, pattern, 0);
    }

    public static String matcherOne (String source, String pattern, int groupIndex)
    {
        List<String> matcher = matcher(source, pattern, groupIndex);
        if (matcher.size() >= 1)
            return matcher.get(0);
        else
            return "";
    }

    public static List<String> matcher (String source, String pattern)
    {
        return matcher(source, pattern, 0);
    }

    public static List<String> matcher (String source, String pattern, int groupIndex)
    {
        List<String> reList = new ArrayList<>();
        Pattern regex = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(source);
        while (regexMatcher.find())
        {
            reList.add(regexMatcher.group(groupIndex));
        }
        return reList;
    }
}
