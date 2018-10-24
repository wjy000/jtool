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
     * @return
     */
    public static <T> T[] toArray (List<T> list, T[] arrays)
    {
        if (list != null)
            return list.toArray(arrays);
        else
            return arrays;
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

    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray (Object obj)
    {
        if (null == obj)
        {
            // throw new NullPointerException("Object check for isArray is null");
            return false;
        }
        return obj.getClass().isArray();
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString (Object obj)
    {
        if (null == obj)
        {
            return null;
        }
        if (isArray(obj))
        {
            try
            {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception e)
            {
                final String className = obj.getClass().getComponentType().getName();
                switch (className)
                {
                    case "long":
                        return Arrays.toString((long[]) obj);
                    case "int":
                        return Arrays.toString((int[]) obj);
                    case "short":
                        return Arrays.toString((short[]) obj);
                    case "char":
                        return Arrays.toString((char[]) obj);
                    case "byte":
                        return Arrays.toString((byte[]) obj);
                    case "boolean":
                        return Arrays.toString((boolean[]) obj);
                    case "float":
                        return Arrays.toString((float[]) obj);
                    case "double":
                        return Arrays.toString((double[]) obj);
                    default:
                        throw new IllegalArgumentException(e);
                }
            }
        }
        return obj.toString();
    }

    /**
     * 是否包含{@code null}元素
     *
     * @param <T>   数组元素类型
     * @param array 被检查的数组
     * @return 是否包含{@code null}元素
     * @since 3.0.7
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean hasNull (T... array)
    {
        if (isNotEmpty(array))
        {
            for (T element : array)
            {
                if (null == element)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 数组是否为非空
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 是否为非空
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean isNotEmpty (final T... array)
    {
        return (array != null && array.length != 0);
    }
}










