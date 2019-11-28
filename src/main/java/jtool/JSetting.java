package jtool;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.Collections;
import java.util.List;


/**
 * Created by Administrator on 2017/4/7.
 * 基于json的配置文件封装
 */
public class JSetting
{
    public static final JSetting ins = new JSetting("jsetting.json");
    private JsonObject root;
    private String mFilePath;

    public JSetting (String filePath)
    {
        mFilePath = filePath;
        try
        {
            File file = new File(filePath);
            if (file.exists())
            {
                String readFile = JFile.readFile(file);
                if (!JString.isEmpty(readFile))
                    this.root = new JsonParser().parse(readFile).getAsJsonObject();
                else
                    this.root = new JsonObject();
            } else
                this.root = new JsonObject();
        } catch (Exception e)
        {
            e.printStackTrace();
            this.root = new JsonObject();
        }
    }

    public JsonObject root ()
    {
        return root;
    }

    public void save ()
    {
        try
        {
            String saveText = root.toString();
            JFile.writeFile(mFilePath, saveText);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void clear ()
    {
        root = new JsonObject();
    }

    public String getString (String key)
    {
        return getString(key, "");
    }

    public String getString (String key, String def)
    {
        if (root.has(key))
            return root.get(key).getAsString();
        else
            return def;
    }

    public int getInt (String key)
    {
        return getInt(key, 0);
    }

    public int getInt (String key, int def)
    {
        if (root.has(key))
            return root.get(key).getAsInt();
        else
            return def;
    }

    public long getLong (String key)
    {
        return getLong(key, 0);
    }

    public long getLong (String key, long def)
    {
        if (root.has(key))
            return root.get(key).getAsLong();
        else
            return def;
    }

    public double getDouble (String key)
    {
        return getDouble(key, 0);
    }

    public double getDouble (String key, double def)
    {
        if (root.has(key))
            return root.get(key).getAsDouble();
        else
            return def;
    }

    public float getFloat (String key)
    {
        return getFloat(key, 0);
    }

    public float getFloat (String key, float def)
    {
        if (root.has(key))
            return root.get(key).getAsFloat();
        else
            return def;
    }

    public boolean getBoolean (String key)
    {
        return getBoolean(key, false);
    }

    public boolean getBoolean (String key, boolean def)
    {
        if (root.has(key))
            return root.get(key).getAsBoolean();
        else
            return def;
    }

    public JsonObject getJsonObject (String key)
    {
        return getJsonObject(key, new JsonObject());
    }

    public JsonObject getJsonObject (String key, JsonObject def)
    {
        if (root.has(key))
            return root.get(key).getAsJsonObject();
        else
            return def;
    }

    public JsonArray getJsonArray (String key)
    {
        return getJsonArray(key, new JsonArray());
    }

    public JsonArray getJsonArray (String key, JsonArray def)
    {
        if (root.has(key))
            return root.get(key).getAsJsonArray();
        else
            return def;
    }

    public <T> T getObject (String key, Class<T> tClass)
    {
        return getObject(key, tClass, null);
    }

    public <T> T getObject (String key, Class<T> tClass, T def)
    {
        String string = getString(key, new Gson().toJson(def));
        return new Gson().fromJson(string, tClass);
    }

    public <T> List<T> getObjects (String key)
    {
        return getObjects(key, Collections.emptyList());
    }

    public <T> List<T> getObjects (String key, List<T> def)
    {
        String string = getString(key, new Gson().toJson(def));
        return new Gson().fromJson(string, new TypeToken<List<T>>()
        {
        }.getType());
    }

    public void put (String key, String val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, int val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, long val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, double val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, float val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, boolean val)
    {
        root.addProperty(key, val);
    }

    public void put (String key, JsonObject val)
    {
        root.add(key, val);
    }

    public void put (String key, JsonArray val)
    {
        root.add(key, val);
    }

    public <T> void put (String key, T val)
    {
        String json = new Gson().toJson(val);
        put(key, json);
    }

    public <T> void put (String key, List<T> val)
    {
        put(key, new Gson().toJson(val));
    }
}





















