package jtool;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PC on 2016/5/2 0002.
 */
public class JString
{
    public static final char C_SEMICOLON = '\"';
    public static final char C_SPACE = ' ';
    public static final char C_TAB = '	';
    public static final char C_DOT = '.';
    public static final char C_SLASH = '/';
    public static final char C_BACKSLASH = '\\';
    public static final char C_CR = '\r';
    public static final char C_LF = '\n';
    public static final char C_UNDERLINE = '_';
    public static final char C_COMMA = ',';
    public static final char C_DELIM_START = '{';
    public static final char C_DELIM_END = '}';
    public static final char C_BRACKET_START = '[';
    public static final char C_BRACKET_END = ']';
    public static final char C_COLON = ':';

    public static final String SPACE = " ";
    public static final String TAB = "	";
    public static final String DOT = ".";
    public static final String DOUBLE_DOT = "..";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String EMPTY = "";
    public static final String CR = "\r";
    public static final String LF = "\n";
    public static final String CRLF = "\r\n";
    public static final String UNDERLINE = "_";
    public static final String COMMA = ",";
    public static final String DELIM_START = "{";
    public static final String DELIM_END = "}";
    public static final String BRACKET_START = "[";
    public static final String BRACKET_END = "]";
    public static final String COLON = ":";

    public static final String HTML_NBSP = "&nbsp;";
    public static final String HTML_AMP = "&amp";
    public static final String HTML_QUOTE = "&quot;";
    public static final String HTML_LT = "&lt;";
    public static final String HTML_GT = "&gt;";

    public static final String EMPTY_JSON = "{}";

    /**
     * 除去  /n /r /t 空格
     *
     * @return
     */
    public static String removeNRTS (String text)
    {
        text = text.replace("\n", "");
        text = text.replace("\r", "");
        text = text.replace("\t", "");
        text = text.replace(" ", "");
        return text;
    }

    public static boolean isEmpty (String text)
    {
        return text == null || text.isEmpty();
    }

    /**
     * Determines if string array contains empty strings.
     */
    public static boolean isAllEmpty (String... strings)
    {
        for (String string : strings)
        {
            if (!isEmpty(string))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串是否为空，空的定义如下 1、为null <br>
     * 2、为""<br>
     *
     * @param str 被检测的字符串
     * @return 是否为空
     */
    public static boolean isEmpty (CharSequence str)
    {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串是否为非空白 空白的定义如下： <br>
     * 1、不为null <br>
     * 2、不为""<br>
     *
     * @param str 被检测的字符串
     * @return 是否为非空
     */
    public static boolean isNotEmpty (CharSequence str)
    {
        return false == isEmpty(str);
    }

    /**
     * 是否包含空字符串
     *
     * @param strs 字符串列表
     * @return 是否包含空字符串
     */
    public static boolean hasEmpty (CharSequence... strs)
    {
        if (JArray.isEmpty(strs))
        {
            return true;
        }

        for (CharSequence str : strs)
        {
            if (isEmpty(str))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否全部为空字符串
     *
     * @param strs 字符串列表
     * @return 是否全部为空字符串
     */
    public static boolean isAllEmpty (CharSequence... strs)
    {
        if (JArray.isEmpty(strs))
        {
            return true;
        }

        for (CharSequence str : strs)
        {
            if (isNotEmpty(str))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * is null or its length is 0 or it is made by space
     *
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     *
     * @param str
     * @return if string is null or its size is 0 or it is made by space, return true, else return false.
     */
    public static boolean isBlank (String str)
    {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 是否包含空字符串
     *
     * @param strs 字符串列表
     * @return 是否包含空字符串
     */
    public static boolean hasBlank (String... strs)
    {
        if (JArray.isEmpty(strs))
        {
            return true;
        }

        for (String str : strs)
        {
            if (isBlank(str))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns string representation of an object, while checking for <code>null</code>.
     */
    public static String toString (Object value)
    {
        if (value == null)
        {
            return null;
        }
        return value.toString();
    }

    public static String utf8Encode (String str, String defultReturn)
    {
        if (!isEmpty(str) && str.getBytes().length != str.length())
        {
            try
            {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e)
            {
                return defultReturn;
            }
        }
        return str;
    }

    public static int length (String str)
    {
        return str == null ? 0 : str.length();
    }

    public static boolean isEquals (String str1, String str2)
    {
        if (str1 == null)
        {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    /**
     * 进行url编码
     *
     * @param text
     * @return
     */
    public static String encodeUrl (String text)
    {
        String result = "";
        try
        {
            result = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 进行url解码
     *
     * @param text
     * @return
     */
    public static String decoderUrl (String text)
    {
        String result = "";
        try
        {
            result = URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Unicode("\u7b80\u4ecb")编码转换成中文
     *
     * @param dataStr Unicode文本
     * @return 转换失败返回原文本, 例如非\u7b80\u4ecb形式的就会失败
     */
    public static String decodeUnicode1 (String dataStr)
    {
        try
        {
            int start = 0;
            int end = 0;
            final StringBuffer buffer = new StringBuffer();
            while (start > -1)
            {
                end = dataStr.indexOf("\\u", start + 2);
                String charStr = "";
                if (end == -1)
                {
                    charStr = dataStr.substring(start + 2, dataStr.length());
                } else
                {
                    charStr = dataStr.substring(start + 2, end);
                }
                char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
                buffer.append(new Character(letter).toString());
                start = end;
            }
            return buffer.toString();
        } catch (Exception e)
        {
            return dataStr;
        }
    }

    /**
     * 转成中文
     *
     * @param text
     * @return
     */
    //unicode("&#26080;&#35770;&#20309;")
    public static String decodeUnicode2 (String text)
    {
        String regExp = "&#\\d*;";
        Matcher m = Pattern.compile(regExp).matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find())
        {
            String s = m.group(0);
            s = s.replaceAll("(&#)|;", "");
            char c = (char) Integer.parseInt(s);
            m.appendReplacement(sb, Character.toString(c));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 重复某个字符
     *
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat (char c, int count)
    {
        if (count <= 0)
        {
            return EMPTY;
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++)
        {
            result[i] = c;
        }
        return new String(result);
    }

    /**
     * 重复某个字符串
     *
     * @param str   被重复的字符
     * @param count 重复的数目
     * @return 重复字符字符串
     */
    public static String repeat (CharSequence str, int count)
    {
        if (null == str)
        {
            return null;
        }
        if (count <= 0)
        {
            return EMPTY;
        }
        if (count == 1 || str.length() == 0)
        {
            return str.toString();
        }

        // 检查
        final int len = str.length();
        final long longSize = (long) len * (long) count;
        final int size = (int) longSize;
        if (size != longSize)
        {
            throw new ArrayIndexOutOfBoundsException("Required String length is too large: " + longSize);
        }

        final char[] array = new char[size];
        str.toString().getChars(0, len, array, 0);
        int n;
        for (n = len; n < size - n; n <<= 1)
        {// n <<= 1相当于n *2
            System.arraycopy(array, 0, array, n, n);
        }
        System.arraycopy(array, 0, array, n, size - n);
        return new String(array);
    }

    /**
     * 比较两个字符串（大小写不敏感）。
     *
     * <pre>
     * equalsIgnoreCase(null, null)   = true
     * equalsIgnoreCase(null, &quot;abc&quot;)  = false
     * equalsIgnoreCase(&quot;abc&quot;, null)  = false
     * equalsIgnoreCase(&quot;abc&quot;, &quot;abc&quot;) = true
     * equalsIgnoreCase(&quot;abc&quot;, &quot;ABC&quot;) = true
     * </pre>
     *
     * @param str1 要比较的字符串1
     * @param str2 要比较的字符串2
     * @return 如果两个字符串相同，或者都是<code>null</code>，则返回<code>true</code>
     */
    public static boolean equalsIgnoreCase (CharSequence str1, CharSequence str2)
    {
        if (str1 == null)
        {
            return str2 == null;
        }

        return str1.toString().equalsIgnoreCase(str2.toString());
    }

    /**
     * 有序的格式化文本，使用{number}做为占位符<br>
     * 例：<br>
     * 通常使用：format("this is {0} for {1}", "a", "b") =》 this is a for b<br>
     *
     * @param pattern   文本格式
     * @param arguments 参数
     * @return 格式化后的文本
     */
    public static String indexedFormat (CharSequence pattern, Object... arguments)
    {
        return MessageFormat.format(pattern.toString(), arguments);
    }

    /**
     * 判断是否包含中文
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese (String str)
    {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find())
        {
            return true;
        }
        return false;
    }

    /**
     * 解码字节码
     *
     * @param data    字符串
     * @param charset 字符集，如果此字段为空，则解码的结果取决于平台
     * @return 解码后的字符串
     */
    public static String str (byte[] data, String charset)
    {
        if (data == null)
        {
            return null;
        }

        if (null == charset)
        {
            return new String(data);
        }
        return new String(data, Charset.forName(charset));
    }

    /**
     * 编码字符串
     *
     * @param str     字符串
     * @param charset 字符集，如果此字段为空，则解码的结果取决于平台
     * @return 编码后的字节码
     */
    public static byte[] bytes (String str, String charset)
    {
        if (str == null)
        {
            return null;
        }
        if (null == charset)
        {
            return str.getBytes();
        }
        return str.getBytes(Charset.forName(charset));
    }

    /**
     * 将对象转为字符串<br>
     * 1、Byte数组和ByteBuffer会被转换为对应字符串的数组 2、对象数组会调用Arrays.toString方法
     *
     * @param obj     对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String str (Object obj, Charset charset)
    {
        if (null == obj)
        {
            return null;
        }

        if (obj instanceof String)
        {
            return (String) obj;
        } else if (obj instanceof byte[])
        {
            return str((byte[]) obj, charset);
        } else if (obj instanceof Byte[])
        {
            return str((Byte[]) obj, charset);
        } else if (obj instanceof ByteBuffer)
        {
            return str((ByteBuffer) obj, charset);
        } else if (JArray.isArray(obj))
        {
            return JArray.toString(obj);
        }

        return obj.toString();
    }

    /**
     * 格式化字符串<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") =》 this is a for b<br>
     * 转义{}： 	format("this is \\{} for {}", "a", "b") =》 this is \{} for a<br>
     * 转义\：		format("this is \\\\{} for {}", "a", "b") =》 this is \a for b<br>
     *
     * @param strPattern 字符串模板
     * @param argArray   参数列表
     * @return 结果
     */
    public static String format (final String strPattern, final Object... argArray)
    {
        if (JString.isBlank(strPattern) || JArray.isEmpty(argArray))
        {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();

        //初始化定义好的长度以获得更好的性能
        StringBuilder sbuf = new StringBuilder(strPatternLength + 50);

        int handledPosition = 0;//记录已经处理到的位置
        int delimIndex;//占位符所在位置
        for (int argIndex = 0; argIndex < argArray.length; argIndex++)
        {
            delimIndex = strPattern.indexOf(JString.EMPTY_JSON, handledPosition);
            if (delimIndex == -1)
            {//剩余部分无占位符
                if (handledPosition == 0)
                { //不带占位符的模板直接返回
                    return strPattern;
                } else
                { //字符串模板剩余部分不再包含占位符，加入剩余部分后返回结果
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
            } else
            {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == JString.C_BACKSLASH)
                {//转义符
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == JString.C_BACKSLASH)
                    {//双转义符
                        //转义符之前还有一个转义符，占位符依旧有效
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(JString.str(argArray[argIndex], Charset.forName(JCharset.UTF_8)));
                        handledPosition = delimIndex + 2;
                    } else
                    {
                        //占位符被转义
                        argIndex--;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(JString.C_DELIM_START);
                        handledPosition = delimIndex + 1;
                    }
                } else
                {//正常占位符
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(JString.str(argArray[argIndex], Charset.forName(JCharset.UTF_8)));
                    handledPosition = delimIndex + 2;
                }
            }
        }
        // append the characters following the last {} pair.
        //加入最后一个占位符后所有的字符
        sbuf.append(strPattern, handledPosition, strPattern.length());

        return sbuf.toString();
    }

    public static double toDouble (String num)
    {
        return toDouble(num, 0);
    }

    public static double toDouble (String num, double def)
    {
        try
        {
            return Double.parseDouble(num);
        } catch (Throwable e)
        {
            return def;
        }
    }

    public static float toFloat (String num)
    {
        return toFloat(num, 0);
    }

    public static float toFloat (String num, float def)
    {
        try
        {
            return Float.parseFloat(num);
        } catch (Throwable e)
        {
            return def;
        }
    }

    public static int toInt (String num)
    {
        return toInt(num, 0);
    }

    public static int toInt (String num, int def)
    {
        try
        {
            return Integer.parseInt(num);
        } catch (Throwable e)
        {
            return def;
        }
    }

    public static long toLong (String num)
    {
        return toLong(num, 0);
    }

    public static long toLong (String num, long def)
    {
        try
        {
            return Long.parseLong(num);
        } catch (Throwable e)
        {
            return def;
        }
    }

    public static boolean toBoolean (String num, boolean def)
    {
        try
        {
            return Boolean.parseBoolean(num);
        } catch (Throwable e)
        {
            return def;
        }
    }
}
