package inkandsoul.ctapi.recipe;

import com.google.gson.JsonObject;
import inkandsoul.ctapi.util.json.JsonArrayBuilder;
import inkandsoul.ctapi.util.json.JsonObjectBuilder;
import inkandsoul.ctapi.util.SmallGrid;
import net.minecraft.resources.ResourceLocation;

public class ShapedCraftingMap {

    private final SmallGrid<String> ids;
    private final SmallGrid<Boolean> isTags;
    private final SmallGrid<Boolean> isNull;
    private final byte height;
    private final byte width;

    public ShapedCraftingMap(byte height, byte width) {
        this.height = height;
        this.width = width;
        this.ids = new SmallGrid<>(height, width, "");
        this.isTags = new SmallGrid<>(height, width, false);
        this.isNull = new SmallGrid<>(height, width, true);
    }

    public ShapedCraftingMap setStackToItem(byte x, String id){
        isTags.set(x, false);
        ids.set(x, id);
        isNull.set(x, false);
        return this;
    }

    public ShapedCraftingMap setStackToTag(byte x, String id){
        isTags.set(x, true);
        ids.set(x, id);
        isNull.set(x, false);
        return this;
    }

    public ShapedCraftingMap setStackToNull(byte x){
        ids.set(x, "");
        isNull.set(x, true);
        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public String toRecipeJson(ResourceLocation result, int count){
        return toRecipeJsonNew(result, count).toString();
    }

    public JsonObject toRecipeJsonNew(ResourceLocation result, int count){
        JsonObjectBuilder builder = new JsonObjectBuilder();

        // Type
        builder.add("type", "minecraft:crafting_shaped");

        // Key
        JsonObjectBuilder keys = new JsonObjectBuilder();
        for(byte i = 0; i < ids.size(); i++){
            JsonObjectBuilder key = new JsonObjectBuilder();

            if(isNull.get(i)){
                key.add((isTags.get(i) ? "tag" : "item"), ids.get(i));
            }

            keys.add(Byte.toString(i), key.get().getAsJsonObject());
        }
        builder.add("key", keys.get().getAsJsonObject());

        // Pattern
        JsonArrayBuilder pattern = new JsonArrayBuilder();
        for(byte row = 0; row < height; row++){
            StringBuilder tmp = new StringBuilder();

            for(byte column = 0; column < width; column++){
                boolean bl = !isNull.get((byte)(row+column));
                if(bl){
                    tmp.append(column+ width);
                }
            }
            pattern.add(tmp.toString());
        }
        builder.add("pattern", pattern.get().getAsJsonArray());

        // Result
        JsonObjectBuilder resultInfo = new JsonObjectBuilder();
        builder.add("result", resultInfo.get().getAsJsonObject());

        return builder.get().getAsJsonObject();
    }
}
