package jtool.jfinal;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;


/**
 * render工具类
 */
public class JRender {
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    private static void _render(Controller controller, int code, JsonElement... element) {
        JsonObject object = new JsonObject();
        object.addProperty("code", code);
        for (int i = 0; i < element.length; i++) {
            if (i == 0)
                object.add("result", element[i]);
            else
                object.add("result" + i, element[i]);
        }
        controller.renderJson(object.toString());
    }

    /**
     * render
     *
     * @param controller controller
     * @param code       code
     * @param objects    result
     */
    public static void render(Controller controller, int code, Object... objects) {
        JsonElement[] element = new JsonElement[objects.length];
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            if (object instanceof Model) {
                element[i] = JSON_PARSER.parse(((Model) object).toJson());
            } else if (object instanceof JsonElement) {
                element[i] = (JsonElement) object;
            } else if (object instanceof List) {
                String json = JsonKit.toJson(object);
                element[i] = JSON_PARSER.parse(json);
            } else {
                element[i] = GSON.toJsonTree(object);
            }
        }
        _render(controller, code, element);
    }
}
