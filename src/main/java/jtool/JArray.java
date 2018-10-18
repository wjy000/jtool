package jtool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public class JArray
{

    private JArray ()
    {
        throw new AssertionError();
    }

    public static <V> int getSize (List<V> sourceList)
    {
        return sourceList == null ? 0 : sourceList.size();
    }

    public static <V> boolean isEmpty (List<V> sourceList)
    {
        return sourceList == null || sourceList.size() == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static <T> boolean isEmpty (final T[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final long[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final int[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final short[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final char[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final byte[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final double[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final float[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 数组是否为空
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty (final boolean[] array)
    {
        return array == null || array.length == 0;
    }

    /**
     * 克隆数组
     *
     * @param array 被克隆的数组
     * @return 新数组
     */
    public static <T> T[] clone (T[] array)
    {
        if (array == null)
        {
            return null;
        }
        return array.clone();
    }

    /**
     * 克隆数组,数组里面的对象引用地址仍然不变
     *
     * @param array 被克隆的数组
     * @return 新数组
     */
    public static <T> List<T> clone (List<T> array)
    {
        if (array == null)
            return null;
        List<T> relist = new ArrayList<T>();
        for (T clone : array)
        {
            relist.add(clone);
        }
        return relist;
    }

    public static <T> boolean isIn (T find, List<T> list)
    {
        for (T t : list)
        {
            if (t.equals(find))
                return true;
        }
        return false;
    }

    public static <T> boolean isIn (T find, T[] list)
    {
        for (T t : list)
        {
            if (t.equals(find))
                return true;
        }
        return false;
    }

    public static boolean isIn (int find, int[] list)
    {
        for (int t : list)
        {
            if (t == find)
                return true;
        }
        return false;
    }

    public static boolean isIn (float find, float[] list)
    {
        for (float t : list)
        {
            if (t == find)
                return true;
        }
        return false;
    }

    public static boolean isIn (double find, double[] list)
    {
        for (double t : list)
        {
            if (t == find)
                return true;
        }
        return false;
    }

    public static boolean isIn (long find, long[] list)
    {
        for (double t : list)
        {
            if (t == find)
                return true;
        }
        return false;
    }

    public static boolean isIn (char find, char[] list)
    {
        for (char t : list)
        {
            if (t == find)
                return true;
        }
        return false;
    }

    /**
     * 转换为array
     *
     * @param list
     * @param <T>
     * @return list=null 则返回null
     */
    public static <T> T[] toArray (List<T> list)
    {
        if (list != null)
            return (T[]) list.toArray();
        else
            return null;
    }

    /**
     * array 转 List
     * array=null时返回空list
     *
     * @param array
     * @param <T>
     * @return 不为空
     */
    public static <T> List<T> toList (T[] array)
    {
        if (array != null)
            return Arrays.asList(array);
        else
            return Collections.emptyList();

    }
}










