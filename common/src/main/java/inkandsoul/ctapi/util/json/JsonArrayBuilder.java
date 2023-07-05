package inkandsoul.ctapi.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonArrayBuilder implements JsonBuilder {

    private final JsonArray array = new JsonArray();

    public JsonBuilder remove(JsonElement key){
        array.remove(key);
        return this;
    }

    public JsonBuilder add(JsonObject obj) {
        return this;
    }

    public JsonBuilder add(JsonArray arr) {
        this.array.add(arr);
        return this;
    }

    public JsonBuilder add(String str) {
        this.array.add(str);
        return this;
    }

    public JsonBuilder add(Integer value) {
        this.array.add(value);
        return this;
    }

    public JsonBuilder add(Boolean value) {
        this.array.add(value);
        return this;
    }

    public JsonBuilder add(Character value) {
        this.array.add(value);
        return this;
    }

    @Override
    public JsonElement get() {
        return array;
    }
    
}
