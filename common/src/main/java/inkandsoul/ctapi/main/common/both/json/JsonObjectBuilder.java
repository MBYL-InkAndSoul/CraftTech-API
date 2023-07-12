package inkandsoul.ctapi.main.common.both.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonObjectBuilder implements JsonBuilder {

    private final JsonObject obj = new JsonObject();

    public JsonBuilder remove(String key){
        obj.remove(key);
        return this;
    }

    public JsonBuilder add(String key, JsonObject obj) {
        this.obj.add(key, obj);
        return this;
    }

    public JsonBuilder add(String key, JsonArray arr) {
        this.obj.add(key, arr);
        return this;
    }

    public JsonBuilder add(String key, String str) {
        this.obj.addProperty(key, str);
        return this;
    }

    public JsonBuilder add(String key, Integer value) {
        this.obj.addProperty(key, value);
        return this;
    }

    public JsonBuilder add(String key, Boolean value) {
        this.obj.addProperty(key, value);
        return this;
    }

    public JsonBuilder add(String key, Character value) {
        this.obj.addProperty(key, value);
        return this;
    }

    @Override
    public JsonElement get() {
        return obj;
    }
    
}
