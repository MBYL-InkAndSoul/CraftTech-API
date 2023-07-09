package inkandsoul.ctapi.main.common.both.util.json;
/**
 * @deprecated
 * A fool class. Do not use again!
 */
@Deprecated
public class JsonStringBuilder {
    private final StringBuilder json;

    public JsonStringBuilder() {
        json = new StringBuilder();
    }

    public JsonStringBuilder(String defaults) {
        this();
        json.append(defaults);
    }

    @Override
    public String toString(){
        return json.toString();
    }

    public String toObject(){
        packObject();
        return json.toString();
    }

    public JsonStringBuilder append(String a){
        json.append(a);
        return this;
    }

    public JsonStringBuilder append(char a){
        json.append(a);
        return this;
    }

    private JsonStringBuilder packObject(){
        json.insert(0, '{');
        json.append('}');
        return this;
    }

    private JsonStringBuilder packArray(){
        json.insert(0, '[');
        json.append(']');
        return this;
    }

    private JsonStringBuilder packString(){
        json.insert(0, '"');
        json.append('"');
        return this;
    }

    public JsonStringBuilder object(JsonStringBuilder a){
        json.append(a.packObject().json);
        return this;
    }

    public JsonStringBuilder object(String t){
        return pack('{', t, '}');
    }

    public JsonStringBuilder array(JsonStringBuilder a){
        json.append(a.packArray().json);
        return this;
    }
    
    public JsonStringBuilder array(String t){
        return pack('[', t, ']');
    }

    public JsonStringBuilder string(JsonStringBuilder a){
        json.append(a.packString().json);
        return this;
    }

    public JsonStringBuilder string(String t){
        return pack('"', t);
    }

    public JsonStringBuilder key(String t){
        return pack('"', t).append(':');
    }

    public JsonStringBuilder keyValue(String a, String b){
        return key(a).append(b);
    }

    public JsonStringBuilder keyString(String a, String b){
        return key(a).string(b);
    }

    public JsonStringBuilder keyArray(String a, String b){
        return key(a).array(b);
    }

    public JsonStringBuilder keyObject(String a, String b){
        return key(a).object(b);
    }

    public JsonStringBuilder dot(){
        return append(',');
    }

    private JsonStringBuilder pack(char i, String t){
        return pack(i, t, i);
    }

    private JsonStringBuilder pack(char a, String t, char b){
        json.append(a);
        json.append(t);
        json.append(b);
        return this;
    }
}
