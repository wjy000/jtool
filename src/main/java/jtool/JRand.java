package jtool;

import java.util.Random;


/**
 * Created by Administrator on 2017/2/19.
 */
public class JRand
{
    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private JRand ()
    {
        throw new AssertionError();
    }

    /**
     * 获得指定长度数字,小写字母,大写字母混合的字符串
     *
     * @param length
     * @return
     */
    public static String getRandomNumbersAndLetters (int length)
    {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * 随机一串数字
     *
     * @param length
     * @return
     */
    public static String getRandomNumbers (int length)
    {
        return getRandom(NUMBERS, length);
    }

    /**
     * 随机一串大小写字母
     *
     * @param length
     * @return
     */
    public static String getRandomLetters (int length)
    {
        return getRandom(LETTERS, length);
    }

    /**
     * 随机一串大写字母
     *
     * @param length
     * @return
     */
    public static String getRandomCapitalLetters (int length)
    {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * 随机一串小写字母
     *
     * @param length
     * @return
     */
    public static String getRandomLowerCaseLetters (int length)
    {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * 从字符串中随机一串字符
     *
     * @param source
     * @param length
     * @return
     */
    public static String getRandom (String source, int length)
    {
        return JString.isEmpty(source) ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * 随机组成指定长度的字符串
     *
     * @param sourceChar 源字符数组
     * @param length     任意长度
     * @return
     */
    public static String getRandom (char[] sourceChar, int length)
    {
        if (sourceChar != null && sourceChar.length != 0 && length >= 0)
        {
            StringBuilder str = new StringBuilder(length);
            Random random = new Random();

            for (int i = 0; i < length; ++i)
            {
                str.append(sourceChar[random.nextInt(sourceChar.length)]);
            }

            return str.toString();
        } else
        {
            return null;
        }
    }

    public static int getRandom (int max)
    {
        return getRandom(0, max);
    }

    public static int getRandom (int min, int max)
    {
        return min > max ? 0 : (min == max ? min : min + (new Random()).nextInt(max - min));
    }

    /**
     * 洗牌 打乱数组
     *
     * @param objArray
     * @return
     */
    public static boolean shuffle (Object[] objArray)
    {
        return objArray == null ? false : shuffle(objArray, getRandom(objArray.length));
    }

    public static boolean shuffle (Object[] objArray, int shuffleCount)
    {
        int length;
        if (objArray != null && shuffleCount >= 0 && (length = objArray.length) >= shuffleCount)
        {
            for (int i = 1; i <= shuffleCount; ++i)
            {
                int random = getRandom(length - i);
                Object temp = objArray[length - i];
                objArray[length - i] = objArray[random];
                objArray[random] = temp;
            }

            return true;
        } else
        {
            return false;
        }
    }

    /**
     * 洗牌
     * @param intArray
     * @return
     */
    public static int[] shuffle (int[] intArray)
    {
        return intArray == null ? null : shuffle(intArray, getRandom(intArray.length));
    }

    /**
     * 洗牌
     * @param intArray
     * @param shuffleCount 洗牌次数
     * @return
     */
    public static int[] shuffle (int[] intArray, int shuffleCount)
    {
        int length;
        if (intArray != null && shuffleCount >= 0 && (length = intArray.length) >= shuffleCount)
        {
            int[] out = new int[shuffleCount];

            for (int i = 1; i <= shuffleCount; ++i)
            {
                int random = getRandom(length - i);
                out[i - 1] = intArray[random];
                int temp = intArray[length - i];
                intArray[length - i] = intArray[random];
                intArray[random] = temp;
            }

            return out;
        } else
        {
            return null;
        }
    }
}
